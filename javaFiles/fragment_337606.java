final JFrame f = new JFrame("Checkbox test");
f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
f.addWindowListener(new WindowAdapter() {
    // I store the checkbox state here in a boolean variable:
    boolean save;

    @Override
    public void windowClosing(WindowEvent e) {
        // Now user wants to close the application, ask confirmation:
        // We create a check box with the initial value of the stored state:
        JCheckBox cb = new JCheckBox("Save settings before Exit", save);
        int res = JOptionPane.showConfirmDialog(null,
            new Object[] {"Are you sure you want to Exit?", cb}, "Exit?",
                    JOptionPane.OK_CANCEL_OPTION);

        // Dialog closed, you can save the sate of the check box
        save = cb.isSelected();
        if (res == JOptionPane.OK_OPTION) {
            if (save) {
                // Settings can be saved here.
            }
            // And exit (by disposing the only frame)
            f.dispose();
        }
    }
});
f.getContentPane().add(new JLabel("Try to close the application"));
f.pack();
f.setLocationRelativeTo(null);
f.setVisible(true);