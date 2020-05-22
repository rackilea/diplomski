import java.lang.annotation.*;
import org.glassfish.hk2.api.*;
import org.glassfish.hk2.utilities.*;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.*;

public class Hk2ClassRunner extends BlockJUnit4ClassRunner {

    private final ServiceLocatorFactory factory = ServiceLocatorFactory.getInstance();
    private Class<? extends Binder>[] binderClasses;

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Binders {

        public Class<? extends Binder>[] value();
    }

    public Hk2ClassRunner(Class<?> cls) throws InitializationError {
        super(cls);
        Binders bindersAnno = cls.getClass().getAnnotation(Binders.class);
        if (bindersAnno == null) {
            binderClasses = new Class[0];
        }
    }

    @Override
    public Statement methodInvoker(FrameworkMethod method, final Object test) {
        final Statement statement = super.methodInvoker(method, test);
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                ServiceLocator locator = factory.create(null);
                for (Class<? extends Binder> c : binderClasses) {
                    try {
                        ServiceLocatorUtilities.bind(locator, c.newInstance());
                    } catch (InstantiationException | IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                locator.inject(test);
                statement.evaluate();
                locator.shutdown();
            }
        };
    }
}