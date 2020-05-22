private void setExceptionState(JComponent password) {
    password.setBackground(null);
    UIDefaults overrides = new UIDefaults();
    overrides.put("PasswordField.background", Color.RED);
    password.putClientProperty("Nimbus.Overrides", overrides);
}

private void resetExceptionState(JComponent password) {
    password.setBackground(null);
    UIDefaults overrides = new UIDefaults();
    overrides.put("PasswordField.background", Color.WHITE);
    password.putClientProperty("Nimbus.Overrides", overrides);
}