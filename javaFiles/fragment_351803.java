@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestNodeDao {

  @Configuration
  @Import(HibernateConfig.class)
  static class Config {

      @Bean
      public NodeDao nd() {
        return new NodeDao();
      }
  }

  @Autowired
  private NodeDao nd;

  // ...
}