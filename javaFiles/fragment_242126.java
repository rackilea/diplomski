public MyControlPanel() {
    initComponents();

    JSlider slider = new JSlider();
    slider.setMajorTickSpacing(10);
    slider.setPaintLabels(true);
    slider.setPaintTicks(true);

    JTextField boundary_length = new JTextField("Boundary Length");
    JTextField area = new JTextField("Area");

    setLayout(new FlowLayout());

    this.add(slider);
    this.add(area);
    this.add(boundary_length);

}