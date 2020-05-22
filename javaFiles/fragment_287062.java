public MyClass extends ActionSupport implements ModelDriven
{

  //My list haveing getters and setters
  public String methodName()
  {
    //code here to get the list
  }

  @Override
  public Object getModel() 
  {
    return this;
  }

}