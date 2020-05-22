@Before(only="Application.welcome")
static void logBefore(){
    System.out.println("Inside \"logBefore\" method of App Controller");
}

@After(only="Application.index")
static void logAfter(){
    System.out.println("Inside \"logAfter\" method of App Controller");
}