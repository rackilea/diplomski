System.out.print("Enter your name: ");
String name = kybd.nextLine();
System.out.println("What is your age? ");
int age = kybd.nextInt();
Person person = new Person(name, age);
qPerson.add(person);
kybd.nextLine();