public void stateChanged(ChangeEvent a)
{
    JSlider slider = (JSlider)e.getSource(); // added
    int value = slider.getValue();

    label.setText("Current value: " + value);
}