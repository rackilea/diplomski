button.addFocusListener(new FocusListener() {

    @Override
    public void focusLost(FocusEvent e) {
        AbstractButton btn = (AbstractButton) e.getSource();
        btn.setIcon(DEFAULT_BTN_ICON);
    }

    @Override
    public void focusGained(FocusEvent e) {
        AbstractButton btn = (AbstractButton) e.getSource();
        btn.setIcon(FOCUSED_BTN_ICON);
    }
});