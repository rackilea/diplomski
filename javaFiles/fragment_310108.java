Scanner scanner = new Scanner(System.in);
System.out.println("Name your giraffe.");
String name = scanner.nextLine();     // get user input for name

Giraffe giraffe = new Giraffe(name);  // use the constructor above to set name

System.out.println(giraffe.getName());  // prints name of giraffe