public static void main(String[] args) {
    int n;

    String scanner;

    while (true) {
        JOptionPane.showInputDialog("Please insert an integer:");
        try {
            n = Integer.parseInt(scanner);
            break;
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Not an integer!");
            continue;
        }
    }

    s.close();

    System.out.println(n);
}