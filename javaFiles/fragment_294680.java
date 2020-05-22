private boolean focused; //a field
protected class FocusListenerColorLine implements FocusListener {

    @Override
    public void focusGained(FocusEvent e) {
        firePropertyChange(PROPERTY_LINE_COLOR, colorLineInactive, colorLineActive);
        focused = true;
    }

    @Override
    public void focusLost(FocusEvent e) {
        firePropertyChange(PROPERTY_LINE_COLOR, colorLineActive, colorLineInactive);
        focused = false;
    }
}



@Override
public void paintSafely(Graphics g) {
    super.paintSafely(g);
    paintLine(g);
    changeColorOnFocus(g);
}

protected void changeColorOnFocus(Graphics g) {
    boolean hasFocus = focused;
    JTextComponent c = getComponent();
    if (c == null) {
        return;
    }
    if (hasFocus && (activeBackground != null) && (activeForeground != null)) {
        logicForChangeColorOnFocus(c, activeBackground, activeForeground);
        //TODO create a new changePropriety
        paintLine(c.getGraphics());
    }

    if (!hasFocus && (inactiveBackground != null) && (inactiveForeground != null)) {
        logicForChangeColorOnFocus(c, inactiveBackground, inactiveForeground);
        paintLine(c.getGraphics());
    }
}