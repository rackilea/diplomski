public static void main(String[] args){

    Scanner scan = new Scanner (System.in);
    String pattern = userInputPattern(scan);
    String test = readSomethingElse(scan);
}

private static String readSomethingElse(Scanner scan) {
   System.out.println(". Read something else");
    return scan.nextLine();
}

private static String userInputPattern(Scanner scan) {

    String pattern = "JollyGood";
    System.out.println(". Please enter a pattern to find in the file");
    pattern = scan.nextLine();
    System.out.println("The pattern to be searched: "+ pattern);
    return pattern;
}