@Stateless
public MainClass
{
  @Inject
  ProdDAL dal;

  @PostConstruct
  public void postConstruct()
  {
      DALFactory.setDAL(new DALWrapper(this.dal));
  }
}