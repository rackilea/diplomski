JComboBox combo = new JComboBox();
combo.addItem("Serif");
combo.addItem("Sans");
combo.addActionListener(new ActionListener() {

    Action serif = new StyledEditorKit.FontFamilyAction("Serif", Font.SERIF);
    Action sans = new StyledEditorKit.FontFamilyAction("Sans", Font.SANS_SERIF);

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Sans".equals(e.getActionCommand())) {
            sans.actionPerformed(e);
        } else {
            serif.actionPerformed(e);
        }
    }
});