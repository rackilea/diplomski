// here your array of terms
Scanner scanner = new Scanner(System.in);
String input = null;

System.out.println("Welcome ");
System.out.println("What's on your mind?");
do {
  System.out.print("> ");
  input = scanner.next();
  for (int i = 0; i < keywords.length; i++) {
    if (keywords[i].equalsIgnoreCase(input)) {
      System.out.println("Found keyword!");
      // TODO: You can optimize this
    }
  }
} while (!input.equalsIgnoreCase("bye"));
System.out.println("Alright then, goodbye!");