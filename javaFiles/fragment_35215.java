package injectcontext;

import io.micronaut.context.ApplicationContext;

import javax.inject.Singleton;

@Singleton
public class FirstService {

    private final ApplicationContext applicationContext;

    public FirstService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public boolean isContextNull() {
        return applicationContext == null;
    }
}