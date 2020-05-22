System.out.println("Enter student's name: ");
String name = in.nextLine();
while(!name.matches("[a-zA-Z]+")){
    System.out.println("Please enter a valid name!");
    name = in.nextLine();
}