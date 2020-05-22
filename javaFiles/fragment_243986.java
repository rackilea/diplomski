import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import my.own.library.BeanInformationFromClass;
import my.own.library.PropertyInformationFromClass;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventSource;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PreDeleteEvent;
import org.hibernate.event.spi.PreDeleteEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.hibernate.persister.collection.CollectionPersister;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.entity.Joinable;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

/**
 * @author Andreas Berger (latest modification by $Author$)
 * @version $Id$
 * @created 27.08.13 - 17:49
 */
public class CollectionCacheInvalidator
        implements PostInsertEventListener, PreDeleteEventListener, PreUpdateEventListener {

    private static final Logger LOGGER = Logger.getLogger( CollectionCacheInvalidator.class );

    private Map<String, String> mappedByFieldMapping;

    public void integrate(SessionFactoryImplementor sf, SessionFactoryServiceRegistry registry) {
        EventListenerRegistry eventListenerRegistry = registry.getService( EventListenerRegistry.class );
        eventListenerRegistry.appendListeners( EventType.POST_INSERT, this );
        eventListenerRegistry.appendListeners( EventType.PRE_DELETE, this );
        eventListenerRegistry.appendListeners( EventType.PRE_UPDATE, this );

        mappedByFieldMapping = new HashMap<String, String>();

        Map<String, CollectionPersister> persiters = sf.getCollectionPersisters();
        if ( persiters != null ) {
            for ( CollectionPersister collectionPersister : persiters.values() ) {
                if ( !collectionPersister.hasCache() ) {
                    continue;
                }
                if ( !(collectionPersister instanceof Joinable) ) {
                    continue;
                }
                String oneToManyFieldName = collectionPersister.getNodeName();
                EntityPersister ownerEntityPersister = collectionPersister.getOwnerEntityPersister();
                Class ownerClass = ownerEntityPersister.getMappedClass();

                // Logic to get the mappedBy attribute of the OneToMany annotation.
                BeanInformationFromClass bi = new BeanInformationFromClass( ownerClass );
                PropertyInformationFromClass prop = bi.getProperty( oneToManyFieldName );
                OneToMany oneToMany = prop.getAnnotation( OneToMany.class );
                String mappedBy = null;
                if ( oneToMany != null && StringUtils.isNotBlank( oneToMany.mappedBy() ) ) {
                    mappedBy = oneToMany.mappedBy();
                }
                mappedByFieldMapping.put( ((Joinable) collectionPersister).getName(), mappedBy );
            }
        }
    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
        evictCache( event.getEntity(), event.getPersister(), event.getSession(), null );
    }

    @Override
    public boolean onPreDelete(PreDeleteEvent event) {
        evictCache( event.getEntity(), event.getPersister(), event.getSession(), null );
        return false;
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        evictCache( event.getEntity(), event.getPersister(), event.getSession(), event.getOldState() );
        return false;
    }

    private void evictCache(Object entity, EntityPersister persister, EventSource session, Object[] oldState) {
        try {
            SessionFactoryImplementor factory = persister.getFactory();

            Set<String> collectionRoles = factory.getCollectionRolesByEntityParticipant( persister.getEntityName() );
            if ( collectionRoles == null || collectionRoles.isEmpty() ) {
                return;
            }
            for ( String role : collectionRoles ) {
                CollectionPersister collectionPersister = factory.getCollectionPersister( role );
                if ( !collectionPersister.hasCache() ) {
                    continue;
                }
                if ( !(collectionPersister instanceof Joinable) ) {
                    continue;
                }
                String mappedBy = mappedByFieldMapping.get( ((Joinable) collectionPersister).getName() );
                if ( mappedBy != null ) {
                    int i = persister.getEntityMetamodel().getPropertyIndex( mappedBy );
                    Serializable oldId = null;
                    if ( oldState != null ) {
                        oldId = session.getIdentifier( oldState[i] );
                    }
                    Object ref = persister.getPropertyValue( entity, i );
                    Serializable id = null;
                    if ( ref != null ) {
                        id = session.getIdentifier( ref );
                    }
                    if ( id != null && !id.equals( oldId ) ) {
                        evict( id, collectionPersister, session );
                        if ( oldId != null ) {
                            evict( id, collectionPersister, session );
                        }
                    }
                }
                else {
                    LOGGER.debug( "Evict CollectionRegion " + role );
                    collectionPersister.getCacheAccessStrategy().evictAll();
                }
            }
        }
        catch (Exception e) {
            LOGGER.error( "", e );
        }
    }

    private void evict(Serializable id, CollectionPersister collectionPersister, EventSource session) {
        LOGGER.debug( "Evict CollectionRegion " + collectionPersister.getRole() + " for id " + id );
        collectionPersister.getCacheAccessStrategy().evict(
                session.generateCacheKey(
                        id,
                        collectionPersister.getKeyType(),
                        collectionPersister.getRole()
                )
        );
    }
}