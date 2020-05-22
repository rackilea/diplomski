Scanner scan = new Scanner(System.in);
String word;
do {
    System.out.println("Enter command: for the initial operation of the program, type "help");
    word = scan.nextLine(); 
} while(!word.equals("help"));

// the rest of the code