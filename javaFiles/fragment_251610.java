@Override
    public void setGlassEnabled(boolean enabled) {
        super.setGlassEnabled(enabled);
        Element glass = getGlassElement();
        if (glass != null) {
            glass.getStyle().setPosition(Position.FIXED);
        }
    }