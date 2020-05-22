String error = "Write a number below, between 1-9;";
int number = -1;
do {
    try {
        String userentered = JOptionPane.showInputDialog(error);
        number = Integer.parseInt(userentered);
        if (number < 1 || number > 9) {
            error = "Error";
        }
    } catch (HeadlessException | NumberFormatException e) {
        error = "Error";
    }
} while (number < 1 || number > 9);