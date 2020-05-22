String height = scanner.nextLine();
int iHeight = 3; // Default is 3
if (!height.trim().isEmpty()) { // If not empty
    iHeight = Integer.parseInt(height); // Use that value

    // And display the option to show steps
    System.out.println("Press 'v' or 'V' for a list of moves");
    Scanner show = new Scanner(System.in);
    String c = show.next();
    displayMoves = c.equalsIgnoreCase("v");
}