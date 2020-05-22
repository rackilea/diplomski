class radioPanel extends JPanel {
    private JRadioButton unlock;
    private JRadioButton lock;
    private ButtonGroup rdgroup;

    ...

    public ButtonGroup getButtonGroup() {
        return rdgroup;
    }

    public AbstractButton getUnlock() {
        return unlock;
    }

    public AbstractButton getLock() {
        return lock;
    }
}