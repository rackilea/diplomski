@Primary
    @Bean
    public JpaProperties jpaProperties() {
        JpaProperties properties = new JpaProperties();
        properties.getProperties().put("hibernate.session_factory.interceptor", myInterceptor);
        return properties;
    }