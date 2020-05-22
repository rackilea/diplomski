slider.addChangeListener(new ChangeListener() {

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        int value = slider.getValue();
        ...
    }
});