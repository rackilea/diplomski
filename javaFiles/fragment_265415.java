ConsoleReader con = new ConsoleReader();
con.setPrompt(prompt1);

con.clearScreen();
con.flush();
System.out.println("Press any key to continue...");
con.readCharacter();
con.clearScreen();
con.flush();

System.out.println("Here is a prompt. Do something and press enter to continue...");
String line = con.readLine();
con.clearScreen();
con.flush();

System.out.println("You typed: ");
System.out.println(line);
System.out.println("Press any key to exit. ");
con.readCharacter();
con.clearScreen();
con.flush();