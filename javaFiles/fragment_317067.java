private static String getStringInput(String prompt) {
    String input = JOptionPane.showInputDialog(prompt);

    String nullFlag = "n";
    int i = 1;
    while(i <= 2)

        if(input == null)

        {
            System.exit(0);
        } else if(input.isEmpty())

        {
            i++;
            nullFlag = "y";
            prompt = JOptionPane.showInputDialog("Re-enter: ");
        } else {
            i = 4;
            nullFlag = "n";
        }

    if(!input.isEmpty()) {
        nullFlag = "n";
    }

    if(nullFlag.equals("y")) {
        JOptionPane.showMessageDialog(null, "Null or blank - exiting...");
        System.exit(0);
    }
    return input;  // Change this line
}