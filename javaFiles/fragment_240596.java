class SuperType {
  protected String name;

  public SuperType(String n) {
    setName( n );
  }

  protected void setName( String n ) {
    name = n;
  }    
}

class SubType extends SuperType {
  // setting 'id' happens here
  private int id = new Random().nextInt() + 1;

  {
    // initializer block, setting 'id' could happen here       
  }

  public SubType( String n ) {
    super( n ); 
    // setting 'id' could happen here as well
  }

  @Override
  protected void setName( String n ) {
    name = n + " " + id;
  }    
}