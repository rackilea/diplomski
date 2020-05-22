public LetterBoard() {
    setBackground(Color.GRAY);
    JPanel panel = new JPanel(new GridLayout(0, 14));
    panel.setBackground(datGreen);
    for (int t = 0; t < 4; t++) {
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < TEXT_FIELD_COUNT / SUIT_COUNT; j++) {
                int index = i * (TEXT_FIELD_COUNT / SUIT_COUNT) + j;
                fields[index] = new JTextField("   ");
                fields[index].setEditable(false);
                fields[index].setPreferredSize(new Dimension(50, 50));
                fields[index].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                panel.add(fields[index]);
            }
        }
    }
    panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3), "WHEEL OF FORTUNE"));
    add(panel);
}