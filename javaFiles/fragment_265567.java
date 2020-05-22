public void actionPerformed(ActionEvent e) {
        JTextComponent target = getFocusedComponent();
        if (target instanceof JTextField) {
            JTextField field = (JTextField) target;
            field.postActionEvent();
        }
    }