public static void main(String[] args) {

    int n = 0;

    boolean validInput = false;
    String scanner;

    while (!validInput) {
        scanner = JOptionPane.showInputDialog("Please insert an integer:");
        try {
            n = Integer.parseInt(scanner);
            validInput = true;
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Not an integer!");
            validInput = false;
        }
    }

    System.out.println(n); //I can't use the n even though I give it a value inside my try-catch
}