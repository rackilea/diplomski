public enum EntityTypeEnum
{
  ARTICLE(String.class), // just using some builtin types to demonstrate
  ORDER(Integer.class), 
  CUSTOMER(Double.class), 
  CUSTOMER_SESSION(Short.class);

  private final Class<?> entityClass;

  private EntityTypeEnum(final Class<?> entityClass)
  {
    this.entityClass = entityClass;
  }

  public Class<?> getEntityClass()
  {
    return this.entityClass;
  }
}

class Test
{
  // here, T is the type parameter which is determined from the class type
  public <T> List<T> createList(final Class<T> clazz)
  {
    return new ArrayList<T>();
  }

  // this is the demo code on how to use it    
  public void foo()
  {
    EntityTypeEnum t = EntityTypeEnum.ARTICLE;
    List<?> list = createList(t.getEntityClass());
  }
}