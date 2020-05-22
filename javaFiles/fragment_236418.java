int count = 0;
String input;
int range;
do {
    input = JOptionPane.showInputDialog(quantity);
    try {
        range = Integer.parseInt(input);
    } catch(NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Sorry that input is not valid, please choose a quantity from 1-9");
        count++;
        // set the range outside the range so we go through the loop again.
        range = -1;
    }
} while((range > 9 || range < 1) && (count < 2));

if (count == 2) {
    JOptionPane.showMessageDialog(null, 
            "Sorry you failed to input a valid response, terminating.");
    System.exit(0);
}
return range;