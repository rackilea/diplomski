package org.atmosphere.di;

import java.util.NoSuchElementException;
import java.util.ServiceLoader;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionTarget;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class InjectorProvider {

    private InjectorProvider() {}

    public static Injector getInjector() {
        return LazyProvider.INJECTOR;
    }

    private static final class LazyProvider {
        private static final Injector   INJECTOR;

        static {
            Injector injector = new Injector() {
                @Override public void inject(final Object o) {
                    try {
                        final BeanManager bm = (BeanManager) new InitialContext().lookup("java:comp/BeanManager");
                        final CreationalContext cc = bm.createCreationalContext(null);
                        final InjectionTarget it = bm.createInjectionTarget(bm.createAnnotatedType(o.getClass()));
                        it.inject(o, cc);
                        cc.release();
                    } catch (final NamingException e) {
                        e.printStackTrace();
                    }
                }
            };
            try {
                injector = ServiceLoader.load(Injector.class).iterator().next();
            } catch (final NoSuchElementException e) {}
            INJECTOR = injector;
        }
    }
}