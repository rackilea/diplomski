public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter a String that match [0-9999][A-Z][0-9999][-][0-99]");

    String input = scan.nextLine();

    //If your input match with your String, then print Match, else Not match
    System.out.println(input.matches("[0-9]{1,4}[A-Z][0-9]{1,4}[-][0-9]{1,2}") ? 
            "Match" : "Not Match");
}