MatlabProxyFactoryOptions options = new MatlabProxyFactoryOptions.Builder()
    .setUsePreviouslyControlledSession(true)
    .setHidden(true)
    .setMatlabLocation(null).build(); 

    MatlabProxyFactory factory = new MatlabProxyFactory(options);
    MatlabProxy proxy = factory.getProxy();