// better for this to be a JPanel
class ViewCarPanel extends JPanel {
    Car car;
    private JLabel jLabel = new JLabel();

    public ViewCarPanel() {
        add(new JLabel("Car Make:"));
        add(jLabel);
        setPreferredSize(new Dimension(300, 80));
    }

    public ViewCarPanel(Car car) {
        // so that we init components from the default constructor
        this(); 

        // new ViewCarPanel().setVisible(true);
        jLabel.setText(car.getMake());
    }
}