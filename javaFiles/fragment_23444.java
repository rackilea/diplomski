@Override
protected AppDescriptor configure() {
    return new LowLevelAppDescriptor.Builder(MockServer.class)
            .clientConfig( new DefaultClientConfig())
            .build();
}