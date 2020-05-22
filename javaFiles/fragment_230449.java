private void updateStyles() {
    SynthStyle ss = SynthLookAndFeel.getStyle(this, Region.BUTTON);
    SynthContext sc = new SynthContext(this, Region.BUTTON, ss, getSynthComponentState());

    for (Component c : getComponents()) {
        c.setFont(ss.getFont(sc));
        c.setBackground(ss.getColor(sc, ColorType.BACKGROUND));
        c.setForeground(ss.getColor(sc, ColorType.FOREGROUND));
        // ... and so on if you have other style elements to be changed.
    }
}