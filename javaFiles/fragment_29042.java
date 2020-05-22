jToggleButton1.setUI(new BasicToggleButtonUI());
jToggleButton1.addItemListener(ev -> {
    if (ev.getStateChange() == ItemEvent.SELECTED)
        jToggleButton1.setBackground(Color.RED);
    else
        jToggleButton1.setBackground(null);
});