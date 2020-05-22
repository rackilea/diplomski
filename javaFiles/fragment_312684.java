abstract class ParentBase implements Parent
{
  @Override
  public final Long getParentProperty()
  {
      return parentProperty_;
  }


  protected void setParentProperty(Long value)
  {
      parentProperty_ = value;
  }


  private Long parentProperty_;
}


abstract class ParentBuilder<T extends ParentBuilder<T>>
{
  T withParentProperty(Long value)
  {
      getParent().setParentProperty(value);
      return getThis();
  }


  protected abstract ParentBase getParent();


  protected abstract T getThis();
}


final class ConcreteChild1 extends ParentBase implements Child1
{
  @Override
  public Integer getChild1Property()
  {
      return childProperty_;
  }


  public void setChild1Property(Integer value)
  {
      childProperty_ = value;
  }


  private Integer childProperty_;
}


final class Child1Builder extends ParentBuilder<Child1Builder>
{
  public Child1Builder()
  {
     pending_ = new ConcreteChild1();
  }


  public Child1Builder withChild1Property(Integer value)
  {
      pending_.setChild1Property(value);
      return this;
  }


  @Override
  protected ParentBase getParent()
  {
      return pending_;
  }


  @Override
  protected Child1Builder getThis()
  {
      return this;
  }


  private final ConcreteChild1 pending_;
}