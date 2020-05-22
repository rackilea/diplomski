int optionType = JOptionPane.DEFAULT_OPTION;
int messageType = JOptionPane.PLAIN_MESSAGE; // no standard icon

JButton ok = new JButton("ok");
JButton cancel = new JButton("cancel");
//add any handlers to the buttons
...
//construct options
Object[] selValues = { ok, cancel };

//show dialog as normal, selected index will be returned.
int res = JOptionPane.showOptionDialog(null, "message",
        "title", optionType, messageType, null, selValues,
        selValues[0]);