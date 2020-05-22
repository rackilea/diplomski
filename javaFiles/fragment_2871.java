public class Main extends JFrame {

public Main() {
    super("Table Demo");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(300, 300));
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    DefaultTableModel model = new DefaultTableModel();
    model.setColumnCount(5);
    model.setRowCount(5);

    JTable table = new JTable();
    table.setModel(model);

    //Get an instance of the column and the style to apply and hold a default style instance
    final TableColumn column = table.getColumnModel().getColumn(1);
    final CellHighlighterRenderer cellRenderer = new CellHighlighterRenderer();
    final TableCellRenderer defaultRenderer = column.getCellRenderer();

    //Now in your button listener you can toggle between the styles 
    JButton button = new JButton("Click!");
    button.addActionListener(new ActionListener() {
        private boolean clicked = false;

        @Override
        public void actionPerformed(ActionEvent e) {

            if (clicked) {
                column.setCellRenderer(cellRenderer);
                clicked = false;
            } else {
                column.setCellRenderer(defaultRenderer);
                clicked = true;
            }
            repaint(); //edit
        }
    });

    getContentPane().add(table, BorderLayout.CENTER);
    getContentPane().add(button, BorderLayout.NORTH);
    pack();
    setVisible(true);
}

public static void main(String[] args) {
     new Main();
}