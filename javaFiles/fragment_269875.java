int number = -1;
while (number != 0) {
    String ans_s = JOptionPane.showInputDialog( "Please enter a rating between 1-10 (0 to stop)");
    number = Integer.parseInt(ans_s);
    if (number > 10 || number < 0) {
        JOptionPane.showMessageDialog( null, "Please Try Again");
        ans_s = JOptionPane.showInputDialog( "Please enter a number between 1-10 (0 to stop)");
        number = Integer.parseInt(ans_s);
    }
    else if (number < 10 || number > 0) {
        ans_s = JOptionPane.showInputDialog( "Please enter a rating between 1-10 (0 to stop)");
    }
    else if (number == 0) {
         JOptionPane.showMessageDialog(null, "Finished");
    }
}