public static void main(String[] Args) {
    String playerName = "";
    System.out.print("Enter ship name: ");
    Scanner scanner = new Scanner(System.in);
    String i_playerName = scanner.next();
    System.out.println();
    char[] chars = i_playerName.toCharArray();
    boolean isChar = true;
    for (char c : chars) {
        if (!Character.isLetter(c)) {
            isChar = false;
        }
    }
    if(isChar == true) {
        System.out.println("Your vessel has been named: " + i_playerName);
    }
    else {
        System.out.println("User input is not accepted.");
    }

}