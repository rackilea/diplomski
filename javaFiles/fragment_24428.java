class MyJButton extends JButton {

    private int gridx;
    private int gridy;

    public MyJButton(String label, int gridx, int gridy) {
        super(label);
        this.gridx = gridx;
        this.gridy = gridy;
    }

    public int getGridx() {
        return gridx;
    }

    public int getGridy() {
        return gridy;
    }
}