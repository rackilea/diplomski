public static class MyClass
{
  @JsonIgnore
  private String propertya;

  @JsonGetter( "propertya" )
  public String getPropertya() { return this.propertya; }

  @JsonSetter( "propertyA" )
  public void setPropertya( String a ){ this.propertya = a };
}