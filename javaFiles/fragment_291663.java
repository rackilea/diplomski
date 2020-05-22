Scanner sc= new Scanner(System.in);
System.out.print("Enter your name? >>");
String vYourName = "";
String vPraise = "";
vYourName = sc.next();
vPraise = vYourName + ((vYourName.equals("giacomo"))? ", hi there" : ", how are you") ;
System.out.println(vPraise);