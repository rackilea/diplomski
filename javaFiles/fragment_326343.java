public static void main(String[] args) {
    //init frame - main component
    JFrame frame = new JFrame("SimpleTableDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create and set up the content pane.
    JPanel panel = new JPanel();
    frame.setContentPane(panel);

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    model.addColumn("col1");
    model.addColumn("col2");
    model.addColumn("col3");
    model.addColumn("col4");

    for (int i=1;i<=100;i++){
        model.addRow(new Object[]{i,1,2,3});  //output jtable row
    }
    table.setSize(600, 200);
    JScrollPane scrollPane = new JScrollPane(table);
    panel.add(scrollPane);
    //Display the window.
    frame.pack();
    frame.setVisible(true);
}