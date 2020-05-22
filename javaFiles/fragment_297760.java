import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;

public class ReflectionsPersistenceUnitPostProcessor implements PersistenceUnitPostProcessor {

    private String reflectionsRoot;
    private Logger log = LoggerFactory.getLogger(ReflectionsPersistenceUnitPostProcessor.class);

    @Override
    public void postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo pui) {
            Reflections r = new Reflections(this.reflectionsRoot, new TypeAnnotationsScanner());
            Set<String> entityClasses = r.getStore().getTypesAnnotatedWith(Entity.class.getName());
            Set<String> mappedSuperClasses = r.getStore().getTypesAnnotatedWith(MappedSuperclass.class.getName());

            for (String clzz : mappedSuperClasses)
            {
                    pui.addManagedClassName(clzz);
            }


            for (String clzz : entityClasses)
            {
                    pui.addManagedClassName(clzz);
            }

    }

    public String getReflectionsRoot() {
            return reflectionsRoot;
    }

    public void setReflectionsRoot(String reflectionsRoot) {
            this.reflectionsRoot = reflectionsRoot;
    }
}