Scanner input = new Scanner(new File("System.txt"));
    public void someMethod(){
      input = doSomething(); //say doSomething() returns null
    }
    Public void closeFile()
   {
   if(input != null)
      input.close();
    }