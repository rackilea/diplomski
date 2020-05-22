private static ArrayList<String> nameArray = new ArrayList<>();

public static void newPerson() {
       Scanner scanner = new Scanner(System.in); 

       System.out.print("Name: ");
       name = scanner.nextLine(); 
       nameArray.add(name);
}

public static void personInfo() {
    System.out.print("Current Persons : \n"); 
    StringBuilder arrayOutput = new StringBuilder();
    for ( String something  : nameArray) {
        arrayOutput.append(something);
    }  
    String text = arrayOutput.toString();
    System.out.println(text); 
}