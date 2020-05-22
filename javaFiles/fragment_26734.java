@Wither
  @Size(min = 6,max = 100, message = "The password must be between 6 and 100 characters") 
  private final String password; //guaranteed to be trimmed


  public MyClass(final String password){  
    this.password=  password.trim();
  }