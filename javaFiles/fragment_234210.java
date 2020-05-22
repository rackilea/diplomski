BeanCreationException: Error creating bean with name 'categoryDaoDbImpl': Injection of autowired dependencies failed; **nested exception is**
|
|-> BeanCreationException: Could not autowire field: private SessionFactory CategoryDaoDbImpl.sessionFactory; **nested exception is**
    |
    |-> BeanCreationException: Error creating bean with name 'sessionFactory' defined in class path resource [applicationContext.xml]: Invocation of init method failed; **nested exception is**
        |
        |-> AnnotationException: @OneToOne or @ManyToOne on Payment.projectId references an unknown entity: int at
                org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:334) at 
                org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1214) at
                org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:543) at 
                org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:482) at 
                org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:305) at 
                org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230) at 
                org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:301) at 
                org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:196) at 
                org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:772) at 
                org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:835) at 
                org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:537) at 
                org.springframework.web.context.ContextLoader.configureAndRefreshWebApplicationContext(ContextLoader.java:446) at 
                org.springframework.web.context.ContextLoader.initWebApplicationContext(ContextLoader.java:328) at 
                org.springframework.web.context.ContextLoaderListener.contextInitialized(ContextLoaderListener.java:107)