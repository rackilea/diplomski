public class TestTableColumns {

    public static void main(String[] args) {
        new TestTableColumns();
    }

    public TestTableColumns() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                DefaultTableModel model =new DefaultTableModel(
                                new Object[][] {
                                    {"1", "2"},
                                    {"11", "21"},
                                    {"12", "22"},
                                    {"13", "23"},
                                    {"14", "24"},
                                    {"15", "25"},
                                    {"16", "26"},
                                    {"17", "27"},
                                    {"18", "28"}}, 
                                new Object[] {
                                    "Small", "Big"});

                JTable table = new JTable(model);
                table.setShowHorizontalLines(true);
                table.setShowVerticalLines(true);
                table.setShowGrid(true);
                table.setGridColor(Color.DARK_GRAY);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                table.getColumn("Small").setPreferredWidth(100);
                table.getColumn("Small").setWidth(12);
                table.getColumn("Big").setPreferredWidth(400);
                table.getColumn("Big").setWidth(100);

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }            
        });
    }    
}