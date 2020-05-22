//In your class, somewhere...
public final static String CMD_PRESSED_B1 = "CMD_PRESSED_B1";
public final static String CMD_PRESSED_B2 = "CMD_PRESSED_B2";

//Create buttons
JButton b1 = new JButton();
JButton b2 = new JButton();

//Assign listeners, in this case "this", but it could be any instance implementing ActionListener, since the CMDs above are declared public static
b1.addActionListener(this);
b2.addActionListener(this);

//Assign the unique commands...
b1.setActionCommand(CMD_PRESSED_B1);
b2.setActionCommand(CMD_PRESSED_B2);