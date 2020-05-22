package com.main.simulated

@Startup
@Singleton
public class MainOne {

    @PostConstruct
    private void rebindClass() throws NamingException {
        final Context context = new InitialContext();
        context.rebind("java:/sample/MainOne", this);
    }

    // other methods that will be called

}