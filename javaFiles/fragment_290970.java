private class MyDispatcher implements KeyEventDispatcher {

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_RELEASED) {
            optionselected = e.getKeyChar();
            other = String.valueOf(optionselected).toUpperCase();
            switch (other) {
                case "C":
                    JOptionPane.showMessageDialog(null, "Option 1");
                    break;
                case "T":
                    JOptionPane.showMessageDialog(null, "Option 2");
                    break;
                case "D":
                    JOptionPane.showMessageDialog(null, "Option 3");
                    break;
                case "N":
                    JOptionPane.showMessageDialog(null, "Option 4");
                    break;
                case "O":
                    JOptionPane.showMessageDialog(null, "Option 5");
                    break;
                case "S":
                    JOptionPane.showMessageDialog(null, "Option 6");
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}