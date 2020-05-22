ApplicationContextProvider appContextProvider = new ApplicationContextProvider();
ApplicationContext applicationContext = appContextProvider.getApplicationContext();

AutowireCapableBeanFactory factory = applicationContext.getAutowireCapableBeanFactory();
factory.autowireBean(this);
factory.initializeBean(this, "logJaxSoapMessageHandler");