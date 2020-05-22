register(new AbstractBinder() {
    @Override
    protected void configure() {
        bind(my.custom.ValidationExceptionMapper.class).to(ExceptionMapper.class)
               .in(Singleton.class);
    }
});