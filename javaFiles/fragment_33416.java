public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

    /**
     * Builds JdbcTemplates for beans
     */
    Map<String,String> jdbcTemplateBeanNames = Maps.newHashMap();
    for (DataSourceConfig dsc : configuration.getDatabase()) {
        AbstractBeanDefinition jdbcTemplateDefinition = BeanDefinitionBuilder.rootBeanDefinition("org.springframework.jdbc.core.JdbcTemplate")
                .addPropertyValue("dataSource",
                        BeanDefinitionBuilder.genericBeanDefinition(DriverManagerDataSource.class)
                            .addPropertyValue("driverClassName", dsc.getDriverClassName())
                            .addPropertyValue("url", dsc.getUrl())
                            .addPropertyValue("username", dsc.getUsername())
                            .addPropertyValue("password", dsc.getPassword())
                            .getBeanDefinition()
                )
                .getBeanDefinition();
        String name = BeanDefinitionReaderUtils.registerWithGeneratedName(jdbcTemplateDefinition, registry);
        jdbcTemplateBeanNames.put(dsc.getName(), name);

    }