one:
while (true) {
    x = JOptionPane.showInputDialog(null, "Insert a data");

    if (x.equals("ok")) {
    break one;
    }

    y = y + Integer.parseInt(x);
}

//here is where i need to get using the label
System.out.println("I did break");