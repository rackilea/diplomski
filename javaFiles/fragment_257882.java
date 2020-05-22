private StringProperty foo = new SimpleStringProperty();

public String getFoo()
{
  return foo.get();
}

public void setFoo(String value)
{
  this.foo.set(value);
}

public StringProperty fooProperty()
{
  return foo;
}