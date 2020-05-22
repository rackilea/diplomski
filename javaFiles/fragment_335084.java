public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(new Dimension(400, 200));

    JPanel body = new JPanel();

    double[][] dim = {
            {20, TableLayout.FILL, 20}, // column widths: 20 distance right/left, TableLayout.FILL usable place
            {20, 17, 5, TableLayout.FILL, 20}  // row height: 20 distance up/down, 17 place for label, 5 distance between label-textarea
            };

    body.setLayout(new TableLayout(dim));

    JTextArea oggetto = new JTextArea(5,1);
    oggetto.setOpaque(true);
    oggetto.setBackground(Color.cyan);


    body.add(new JLabel("Inserimento di un nuovo protocollo"), "1,1"); // col: 1, row: 1
    body.add(oggetto, "1,3");// col: 1(TableLayout.FILL), row: 3 (TableLayout.FILL)
    frame.add(body);
    frame.setVisible(true);
}