do {
    name = JOptionPane.showInputDialog(null, "Enter name here : ", "title", JOptionPane.OK_CANCEL_OPTION);
} while(name != null && !name.matches("^[a-zA-Z]+$"));

if (name == null) {
    gamePaused = true;
} else {
    //Do whatever want with the name
}