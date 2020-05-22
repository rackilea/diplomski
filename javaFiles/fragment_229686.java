frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
if (JOptionPane.showConfirmDialog(null, "Are you sure to close this window?", "Confirm closing",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

}});