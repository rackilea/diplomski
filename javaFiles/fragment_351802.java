@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={HibernateConfig.class, TestNodeDao.Config.class})
public class TestNodeDao {

  @Configuration
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