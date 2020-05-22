for (DataSourceConfig dsc : configuration.getDatabase()) {

        BeanDefinitionBuilder datasourceDef = BeanDefinitionBuilder.genericBeanDefinition(DriverManagerDataSource.class);
        datasourceDef.addPropertyValue("driverClassName", dsc.getDriverClassName());
        datasourceDef.addPropertyValue("url", dsc.getUrl());
        datasourceDef.addPropertyValue("username", dsc.getUsername());
        datasourceDef.addPropertyValue("password", dsc.getPassword());

        BeanDefinitionBuilder jdbcTemplateDef = BeanDefinitionBuilder.genericBeanDefinition(org.springframework.jdbc.core.JdbcTemplate.class);
        jdbcTemplateDef.addPropertyValue("dataSource", datasourceDef.getBeanDefinition());

        BeanDefinitionBuilder daoDef = BeanDefinitionBuilder.genericBeanDefinition(com.me.db.RemoteDBDoa.class);
        daoDef.addPropertyValue("jdbcTemplateRemote", jdbcTemplateDef.getBeanDefinition());

        BeanDefinitionBuilder collectorDef = BeanDefinitionBuilder.rootBeanDefinition(com.me.threads.RemoteDataCollector.class);
        collectorDef.addPropertyValue("remoteDBDoa", daoDef.getBeanDefinition());

        String name = BeanDefinitionReaderUtils.registerWithGeneratedName(collectorDefinition.getBeanDefinition(), registry);
        jdbcTemplateBeanNames.put(dsc.getName(), name);

    }