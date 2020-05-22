@Override
public IPageManager get(IPageManagerContext context)
{
    IDataStore dataStore = new HttpSessionDataStore(context, 
                                             new PageNumberEvictionStrategy(10));
    IPageStore pageStore = new DefaultPageStore ( 
                                     new JavaSerializer ( getName() ), dataStore,
                                     getStoreSettings().getInmemoryCacheSize());
    return new PageStoreManager(application.getName(), pageStore,
                                                           context);
}