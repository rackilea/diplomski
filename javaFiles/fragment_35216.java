package injectcontext;

import io.micronaut.context.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SecondService {

    @Inject
    ApplicationContext applicationContext;

    public boolean isContextNull() {
        return applicationContext == null;
    }
}