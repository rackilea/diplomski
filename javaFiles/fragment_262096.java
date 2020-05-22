String input = JOptionPane.showInputDialog(null, ("Some text"));
for (String s : input.split(" ")) {
    int userchoice = Integer.parseInt(s);
    if (userchoice == 1) {    
        // ...
    }
    // ...
}