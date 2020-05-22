class MyResourceConfig extends ResourceConfig
{
    // won't be initialized until onStartup()
    ServiceLocator serviceLocator;

    public MyResourceConfig()
    {
        register(new ContainerLifecycleListener()
        {
            public void onStartup(Container container)
            {
                // access the ServiceLocator here
                serviceLocator = container.getApplicationHandler().getServiceLocator();

                // ... do what you need with ServiceLocator ...
                MyService service = serviceLocator.createAndInitialize(MyService.class);
            }

            public void onReload(Container container) {/*...*/}
            public void onShutdown(Container container) {/*...*/}
        });
    }

    public ServiceLocator getServiceLocator()
    {
        return serviceLocator;
    }
}