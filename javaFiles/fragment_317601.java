Scanner sc = new Scanner(System.in);

// open file and prompt for file name
System.out.print("Enter a file name: ");
String fileName = sc.nextLine();
File infile = new File(fileName);
Scanner readIt = new Scanner(infile);

String greeting = readIt.nextLine();
System.out.println(greeting); //prints hello|howdy|etc...
String[] greetingSplit = greeting.split("\\|");
System.out.println(greetingSplit[0]); //prints hello