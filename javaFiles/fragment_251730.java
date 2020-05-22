register(new AbstractBinder(){
    protected void configure() {
        bind(SessionManager.class).to(SessionManager.class)
                                  .in(RequestScoped.class);
    }
});