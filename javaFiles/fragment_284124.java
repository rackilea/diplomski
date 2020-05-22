// create the datasource bean
    BeanDefinitionBuilder dataSourceBeanBuilder = BeanDefinitionBuilder.rootBeanDefinition(DataSourceConfiguration.class, "createDataSource");
    dataSourceBeanBuilder.addConstructorArgValue(descriptor.getDataSourceDescriptor().getJNDILookupName());
    dataSourceBeanBuilder.addConstructorArgValue(descriptor.getDataSourceDescriptor().isResourceRef());
    moduleContext.registerBeanDefinition("dataSource", dataSourceBeanBuilder.getBeanDefinition());

    // now build the sessionFactor
    BeanDefinitionBuilder sessionFactoryBeanBuilder = BeanDefinitionBuilder.rootBeanDefinition(SessionFactoryFactory.class, "createSessionFactory");
    sessionFactoryBeanBuilder.addConstructorArgReference("dataSource");
    sessionFactoryBeanBuilder.addConstructorArgValue(module.getKey());
    sessionFactoryBeanBuilder.addConstructorArgValue(moduleContext.getModuleResourceLoader());
    sessionFactoryBeanBuilder.addConstructorArgValue(annotatedClasses);
    moduleContext.registerBeanDefinition("sessionFactory", sessionFactoryBeanBuilder.getBeanDefinition());

    // now build the transactionManager
    BeanDefinitionBuilder transactionManagerBeanBuilder = BeanDefinitionBuilder.rootBeanDefinition(HibernateConfigurationFactory.class, "createTransactionManager");
    transactionManagerBeanBuilder.addConstructorArgReference("sessionFactory");
    moduleContext.registerBeanDefinition("transactionManager", transactionManagerBeanBuilder.getBeanDefinition());