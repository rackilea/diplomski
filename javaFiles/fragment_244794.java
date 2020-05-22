int min = 1;
int max = 10;
int initial = 5;

JSpinner inputField =
    new JSpinner(new SpinnerNumberModel(initial, min, max, 1));

int response = JOptionPane.showOptionDialog(frame,
    new Object[] { "Number you want:\n", inputField },
    "Enter number",
    JOptionPane.OK_CANCEL_OPTION,
    JOptionPane.PLAIN_MESSAGE,
    null, null, null);

if (response == JOptionPane.OK_OPTION) {
    int myNumber = (Integer) inputField.getValue();
    // Do stuff with myNumber here
} else {
    System.out.println("User canceled dialog.");
}