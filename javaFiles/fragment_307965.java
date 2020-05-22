@SpringBootApplication
@CacheServerApplication(locators="localhost[10334]", name="GeodeServerApplication" )
@EnableCacheServer(name="neptunus", autoStartup=true, hostnameForClients = "localhost", port = 41414)
@EnableCachingDefinedRegions
@EnableGemfireCaching
@EnablePdx
@EnableManager
@EnableHttpService
@EnableDiskStore(name = "disk_store")
@EnableEntityDefinedRegions(basePackageClasses= {TitleContent.class
}, serverRegionShortcut = RegionShortcut.PARTITION_PERSISTENT)
public class GeodeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeodeServerApplication.class, args);
    }

}