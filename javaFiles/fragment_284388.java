@Bean
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "prototype")
    public UserProfile attachDocController(MyDependency myDependency) throws IOException {
        return new UserProfile(myDependency);
    }

    @Bean
    public MyDependency createDependency() {
        return new MyDependencyImpl();
    }