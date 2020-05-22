@SpringBootApplication
@ClientCacheApplication(logLevel = "debug", locators = {@Locator(host = "localhost", port = 10334)})
@EnablePool(name="neptunusPool", servers=@Server(host="localhost", port=41414))
@EnableGemfireRepositories(basePackageClasses= {TitleContentRepository.class})
@EnableEntityDefinedRegions(basePackageClasses= {TitleContent.class
})
//@ReplicateRegion
//@EnableClusterDefinedRegions
//@EnableCachingDefinedRegions
//@EnableGemfireCaching
@EnableIndexing
//@EnableClusterConfiguration
@EnablePdx

public class CommerceHostGeodeApplication {

    public static void main(String[] args) {

        SpringApplication.run(CommerceHostGeodeApplication.class, args);

    }

}