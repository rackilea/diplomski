public static void main(String... args) {

    // variables
    String str;
    // get input
    Scanner kb = new Scanner(System.in);
    System.out.print(" Please Enter a Word:");
    // accept input
    str = kb.nextLine();
    System.out.print("");
    System.out.println(str.toUpperCase()); // Upper Case

    System.out.println(str.toUpperCase().replace("A", "@").replace("E", "3")
            .replace("E", "3").replace("G", "6").replace("I", "!").replace("S", "$").replace("T", "7") );

}