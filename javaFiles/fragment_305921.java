@Bean
public class Provider1 implements DataProvider { ... }

@Bean
public class Provider2 implements DataProvider { ... }

@Bean
public class Registry{
    @Autowired
    private List<DataProvider> providers;

    public List<DataProvider> getProviders(){
       //return providers
    }

    public Data someAggregatedOperation(){ ... }
}