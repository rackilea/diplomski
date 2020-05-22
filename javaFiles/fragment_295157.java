public enum EntityTypeEnum
{
  ARTICLE(Article.class),
  ORDER(OrderHeader.class),
  CUSTOMER(Customer.class),
  CUSTOMER_SESSION(CustomerSession.class);

  private final Class<? extends CommonParent> entityClass;

  private EntityTypeEnum(final Class<? extends CommonParent> entityClass)
  {
    this.entityClass = entityClass;
  }

  public Class<? extends CommonParent> getEntityClass()
  {
    return this.entityClass;
  }
}

class Test
{
  public <T extends CommonParent> List<T> createList(final Class<T> clazz)
  {
    return new ArrayList<T>();
  }

  public void foo()
  {
    EntityTypeEnum t = EntityTypeEnum.ARTICLE;
    List<? extends CommonParent> list = createList(t.getEntityClass());
  }
}