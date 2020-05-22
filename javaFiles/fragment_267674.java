Scanner input = new Scanner(System.in);
System.out.println("Please enter your name");
String name = input.nextLine();
System.out.println("Enter your age");
Int age = input.nextInt();
PersonDetails a = new PersonDetails(name, age);

System.out.println("So your name is" + " " + a.getName() + " and you are" + " " + a.getAge());