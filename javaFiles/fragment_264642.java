@Override
public void stateChanged(ChangeEvent e) {
    if (slider.getValue() < 50) {
        label.setIcon(pig);
    } else {
        label.setIcon(dog);
    }
}