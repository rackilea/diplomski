public static void main(String[] args) {
    int number;
    while (true) {
        Object[] message = {"Input some number that is not 0: "};
        String numberString = JOptionPane.showInputDialog(null, message, "Add New", JOptionPane.OK_CANCEL_OPTION);
        try {
            number = Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            continue;
        }
        if (number != 0) {
            break;
        } 
    }
    System.out.println(number);
}