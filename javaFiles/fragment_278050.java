JFrame frame = new JFrame("");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JPanel panel = new JPanel();

JFormattedTextField field1 = new JFormattedTextField();
field1.setColumns(10);
JFormattedTextField field2 = new JFormattedTextField();
field2.setColumns(10);
try {
    MaskFormatter mask1 = new MaskFormatter("##:##:##;##");
    mask1.setPlaceholderCharacter('0');
    mask1.install(field1);

    MaskFormatter mask2 = new MaskFormatter("##:##:##;##");
    mask2.setPlaceholderCharacter('0');
    mask2.install(field2);
} catch (ParseException e) {
    e.printStackTrace();
}
panel.add(field1);
panel.add(field2);

frame.add(panel);
frame.pack();
frame.setVisible(true);