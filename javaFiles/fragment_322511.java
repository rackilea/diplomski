@TestConfiguration
    static class PlayerServiceImplTestContextConfiguration {

      @Bean
      @Primary
      public PlayerService playerService(PlayerRepository playerRepository,
            CompanyService companyService, CompanyResourceService companyResourceService) {
        return new PlayerServiceImpl(playerRepository, companyService, companyResourceService);
      }
    }