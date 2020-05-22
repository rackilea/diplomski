int n = 0;
System.out.println("Enter your last name");
String lastName = "";

while (n < 6) {
    System.out.print("Please print the next letter of your last name: ");
    String tmp = your_name.nextLine();
    char c = tmp.charAt(0);

    if (Character.isAlphabetic(c)) {
        lastName += c;
        n++;
    } else {
        System.out.println("You can use only letters! Try again!");
    }
}

System.out.println(lastName);