package core.models.dao;

    import javax.persistence.EntityManagerFactory;

    import org.hibernate.ejb.HibernateEntityManagerFactory;

    import com.google.inject.Inject;
    import com.google.inject.Provider;
    import com.googlecode.genericdao.search.MetadataUtil;
    import com.googlecode.genericdao.search.jpa.hibernate.HibernateMetadataUtil;

    @SuppressWarnings("deprecation")
    public class HibernateMetadataUtilProvider
            implements Provider<MetadataUtil> {

        @Inject
        private EntityManagerFactory emf;

        @Override
        public MetadataUtil get() {
            return HibernateMetadataUtil.getInstanceForEntityManagerFactory((HibernateEntityManagerFactory) emf);
        }
     }