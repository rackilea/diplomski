@Configuration
public class CustomRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration {
    @Override
    public RepositoryRestController repositoryRestController() throws Exception {
        RepositoryRestController restController = new RepositoryRestController(){
            @Override
            public ResponseEntity<?> listRepositories(ServletServerHttpRequest request, URI baseUri) throws IOException {
                throw new RootContextRepositoryException();                
            }
        };

        return restController;
    }
}