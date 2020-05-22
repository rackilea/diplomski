chooser.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        Container parent = chooser.getParent();
        while (!(parent instanceof JOptionPane)) {
            parent = parent.getParent();
        }

        JOptionPane op = (JOptionPane) parent;
        op.setValue("done");

        if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
            System.out.println("File selected: " + chooser.getSelectedFile());
        } else {
        }
    }
});