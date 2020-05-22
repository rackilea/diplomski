public DefaultConfiguration configuration() {
    DefaultConfiguration jooqConfiguration = new DefaultConfiguration();

    // Explicitly set the Dialect
    jooqConfiguration.setSQLDialect(SQLDialect.POSTGRES);

    jooqConfiguration.set(connectionProvider());
    jooqConfiguration.set(new DefaultExecuteListenerProvider(exceptionTransformer()));
    return jooqConfiguration;
}