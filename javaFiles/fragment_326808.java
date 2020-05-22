final JPasswordField pf = new JPasswordField(10);
    JOptionPane op = new JOptionPane(pf, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
    JDialog d = op.createDialog("Test");
    d.addWindowFocusListener(new WindowAdapter() {
        @Override
        public void windowGainedFocus(WindowEvent e) {
            pf.requestFocusInWindow();
        }
    });
    d.pack();
    d.setLocationRelativeTo(null);
    d.setVisible(true);