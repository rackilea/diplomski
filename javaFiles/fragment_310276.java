if (bday.equalsIgnoreCase("true") || bday.equalsIgnoreCase("false")) {
    bage = Boolean.parseBoolean(bday);
} else {
    JOptionPane.showMessageDialog(null, "Invalid choice: Enter true or false.");
    return;
}

if (bage){ // bage == true is unnecessary
    iage += 1;
    JOptionPane.showMessageDialog(null, "You are now " + iage);
} else { // no need to check the condition again
    JOptionPane.showMessageDialog(null, "Happy unbirthday!");
}