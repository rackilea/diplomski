@Bean
public class Provider1 implements DataProvider { ... }

@Bean
public class Provider2 implements DataProvider { ... }

public class Registry{
    private List<DataProvider> providers;

    public Registry(final List<DataProvider> providers) {
      this.providers = providers;
    }

    public List<DataProvider> getProviders(){
       //return providers
    }

    public Data someAggregatedOperation(){ ... }
}

@Configuration
public class MyAppConfiguration{

    @Bean
    @Autowired
    public Registry providerRegistry(final List<DataProvider> providers){
        return new Registry(providers);
    }
}