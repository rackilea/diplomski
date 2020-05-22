String name = "";
while (true) {
    System.out.println("Enter Name");
    name = Keyboard.readString();
    if (name.matches("[a-zA-Z]+"))
        break;
    System.out.println("Invalid input. Enter letters only");
}