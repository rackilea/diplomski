@Configuration
public class MSARepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration {

    @Override
        public RepositoryRestConfiguration config() {
            RepositoryRestConfiguration config = super.config();
            config.setBasePath("/api");
            config.exposeIdsFor(User.class);
            return config; 
        }
}