public static class MyComboBoxUI extends WindowsComboBoxUI {

    @Override
    protected void installDefaults() {
        super.installDefaults();
        LookAndFeel.uninstallBorder(comboBox);
    }

    public static ComponentUI createUI(JComponent c) {
        return new MyComboBoxUI();
    }

}