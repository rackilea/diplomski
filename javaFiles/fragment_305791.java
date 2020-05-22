char enc;
    String encmsg = "";
    String msg = JOptionPane.showInputDialog("Enter your message");
    int len = msg.length();
    for (int i = 0; i < len; i++) {
        char cur = msg.charAt(i);
        int val = (int) cur;
        val = val - 30;
        enc = (char) val;
        encmsg = encmsg + enc;

    }

    JOptionPane.showMessageDialog(null, encmsg);