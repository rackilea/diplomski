MyClass myClassObj=new MyClass();   // creating new instance of MyClass 
System.out.println("Please enter an ID: ");
Scanner scan= new Scanner(System.in);
String userInput=scan.nextLine();   // get user input

myClassObj.setMyField(userInput);   // setting myFiled attribute