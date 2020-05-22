public class ChangeHandler implements ChangeListener {

    private JLabel label;
    private Icon armedIcon;

    public ChangeHandler(JLabel label, Icon armedIcon) {
        this.armedIcon = armedIcon;
        this.label = label;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        ButtonModel model = (ButtonModel) e.getSource();
        if (model.isRollover()) {
            label.setIcon(armedIcon);
        } else {
            label.setIcon(null);
        }
    }

}