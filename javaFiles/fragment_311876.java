@Configuration
@EnableFilesystemStores
@Import(RestConfiguration.class)
public class StoreConfig {

    @Bean
    FileSystemResourceLoader fileSystemResourceLoader() throws IOException {
        return new FileSystemResourceLoader(new File("/mnt").getAbsolutePath());
    }

}