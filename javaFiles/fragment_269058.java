protected void installCustomPasswordFieldState() {
    // implement a custom state
    State<JPasswordField> state = new State<JPasswordField>("Invalid") {

        @Override
        protected boolean isInState(JPasswordField c) {
            Object invalid = c.getClientProperty("Invalid");
            return Boolean.TRUE.equals(invalid);
        }

    };
    UIDefaults defaults = UIManager.getLookAndFeelDefaults();
    // register available states 
    // note: couldn't find a way to grab the already available states
    // so this is guesswork
    defaults.put("PasswordField.States", "Enabled, Focused, Invalid");
    // install the custom state
    defaults.put("PasswordField.Invalid", state);
    // install the properties for the custom state
    // note: background has no effect
    defaults.put("PasswordField[Invalid].background", 
            Color.RED); 
    javax.swing.Painter<JComponent> p = new javax.swing.Painter<JComponent>() {

        @Override
        public void paint(Graphics2D g, JComponent object, int width, int height) {
            g.setColor(Color.RED);
            // this is crude - overpainting the complete area, do better!
            g.fillRect(0, 0, width, height);
        }

    };
    // using a painter has an effect 
    defaults.put("PasswordField[Invalid].backgroundPainter", p);
}

// example usage, toggling
// a new property (for simplicity implemented as clientProperty
// to toggle the invalid state
Action reset = new AbstractAction("reset") {
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isInvalid = Boolean.TRUE.equals(field.getClientProperty("Invalid")); 
        if (isInvalid) {
            field.putClientProperty("Invalid", null); 
        } else {
            field.putClientProperty("Invalid", Boolean.TRUE); 
        }
        field.repaint();
    }
};