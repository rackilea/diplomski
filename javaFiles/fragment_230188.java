@Component("daoRegistry")
public class DaoRegistry {
  @Autowired
  private List<GenericDao> customDaos;

  private GenericDao defaultDao = new GenericDaoImpl();

  public <T> T getDao(Class<T> clazz) {
    // search customDaos for matching clazz, return default dao otherwise
  }
}