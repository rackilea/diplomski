@Configuration
public class AppConfig {

  @Bean
  public ClientService clientService1() {
    ClientServiceImpl clientService = new ClientServiceImpl();
    clientService.setClientDao(clientDao());
    return clientService;
  }
  @Bean
  public ClientService clientService2() {
    ClientServiceImpl clientService = new ClientServiceImpl();
    clientService.setClientDao(clientDao());
    return clientService;
  }

  @Bean
  public ClientDao clientDao() {
    return new ClientDaoImpl();
  }
}