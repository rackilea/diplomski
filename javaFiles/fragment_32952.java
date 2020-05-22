UIManager.addAuxiliaryLookAndFeel(new LookAndFeel() {
    private final UIDefaults defaults = new UIDefaults() {
        @Override
        public javax.swing.plaf.ComponentUI getUI(JComponent c) {
            if (c instanceof javax.swing.text.JTextComponent) {
                if (c.getClientProperty(this) == null) {
                    c.setComponentPopupMenu(TextContextMenu.INSTANCE);
                    c.putClientProperty(this, Boolean.TRUE);
                }
            }
            return null;
        }
    };
    @Override public UIDefaults getDefaults() { return defaults; };
    @Override public String getID() { return "TextContextMenu"; }
    @Override public String getName() { return getID(); }
    @Override public String getDescription() { return getID(); }
    @Override public boolean isNativeLookAndFeel() { return false; }
    @Override public boolean isSupportedLookAndFeel() { return true; }
});