private class NumberPanel extends JPanel {
    private final JLabel label;
    private final JTextField field;

    public NumberPanel(int place) {
        super(new BorderLayout());
        this.label = new JLabel(Integer.toString(place));
        this.field = new JTextField(10);
        add(label, BorderLayout.WEST);
        add(field, BorderLayout.EAST);
    }

    public int getValue() {
        return Integer.valueOf(field.getText());
    }
}

private final List<NumberPanel> numberPanels =
    IntStream.rangeClosed(1, 6)
        .mapToObj(NumberPanel::new).collect(toList());