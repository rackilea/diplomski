private JFrame frame = new JFrame("JComboExample");
private JCheckBox primary = new JCheckBox("Primary");
private JComboBox<String> colorSelector;

private String[] colorsToHide = { "Purple", "Magenta" };

public JComboExample() {
    SwingUtilities.invokeLater(() -> {
        setupFrame();
        setupCheckbox();
        initJComboBox("Purple", "Red", "Blue", "Magenta");
        frame.add(primary, BorderLayout.NORTH);
        frame.add(colorSelector, BorderLayout.CENTER);
    });
}

private void setupFrame() {
    frame.setSize(300, 100);
    frame.setLocationByPlatform(true);
    frame.setDefaultCloseOperation(3);
    frame.setLayout(new BorderLayout());
}

private void setupCheckbox() {
    primary.addActionListener(event -> {
        if(primary.isSelected()) {
            for(String color: colorsToHide) {
                colorSelector.removeItem(color);
            }

        } else {
            for(String color: colorsToHide) {
                colorSelector.addItem(color);
            }
        }
    });
}

private void initJComboBox(String... colors) {
    colorSelector = new JComboBox<String>(colors);
}

public void setVisbility(boolean visibility) {
    frame.setVisible(visibility);
}

public static void main(String[] args) {
    JComboExample example = new JComboExample();
    example.setVisbility(true);
}