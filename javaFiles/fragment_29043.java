private void updateColorIfSelected(JToggleButton btn, ItemEvent ev, Color color) {
    if (ev.getStateChange() == ItemEvent.SELECTED)
        btn.setBackground(color);
    else
        btn.setBackground(null);
}