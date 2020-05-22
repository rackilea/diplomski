ProxyClassLoader classLoader = new ProxyClassLoader();
    classLoader.addLoader(resourceApiClass.getClassLoader());
    classLoader.addLoader(JAXRSClientFactoryBean.class.getClassLoader());

    JAXRSClientFactoryBean bean = new JAXRSClientFactoryBean();
    bean.setAddress(baseUrl);
    bean.setServiceClass(resourceApiClass);
    bean.setClassLoader(classLoader);
    return bean.create(resourceApiClass);