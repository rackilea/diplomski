private String foo;

public void setFoo(String bar)
{
  StringBuilder builder = new StringBuilder();
  builder.append(bar + "bin/");
  foo = builder.toString();
}