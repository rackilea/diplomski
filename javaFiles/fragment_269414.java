Integer w = null;
while (true) {
    String weight = JOptionPane.showInputDialog(null, "Enter your weight in Kg: ");
    if (weight == null) {
        break;
    }

    try {
        w = Integer.parseInt(weight);
        break;
    } catch (NumberFormatException e) { 
        JOptionPane.showMessageDialog(null, "Enter a valid integer", "error", JOptionPane.ERROR_MESSAGE);
    }
}

if (w == null) { //The user clicked cancel
    menuGUI();
} else { //Do what you want with w
}