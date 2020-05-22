@Configuration
@EntityScan("com.skilldistillery.edgemarketing.entities")
@EnableJpaRepositories("com.skilldistillery.myRest.repositories")
public class BusinessConfig {

    @Bean
    public HouseService houseService(final HouseRepo houseRepo){
        return new HouseServiceImpl(houseRepo);
    }   
}