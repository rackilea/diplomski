private void testingLoop() {
    String var[]= {"java", "code", "review"};
    String arr[] = new String[1];
    for(String i : var)
    {
    arr[0] = i.concat("Script");
    }  
    System.out.println("The result is: " +arr[0]);
}