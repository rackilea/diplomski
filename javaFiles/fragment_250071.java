public class JTableTest extends JFrame {

    private JTable      table;
    private int         col;
    private int         rowz;


    /**
     * Create the frame.
     */
    public JTableTest() {
        initComponents();
    }

    private void initComponents() {
        /** any other components */

        table = new JTable();//create the table
        table.setDefaultRenderer(Object.class, new CustomModel());
        table.addMouseListener(new CustomListener());
    }

    public class CustomListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent arg0) {
            super.mouseClicked(arg0);
            //get the clicked cell's row and column
            rowz = table.getSelectedRow();
            col = table.getSelectedColumn();

            // Repaints JTable
            table.repaint();
        }
    }

    public class CustomModel extends DefaultTableCellRenderer {


        private static final long   serialVersionUID    = 1L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Color c = Color.WHITE;//define the color you want
            if (isSelected && row == rowz & column == col)
                c = Color.GREEN;
            label.setBackground(c);
            return label;
        }
    }

}