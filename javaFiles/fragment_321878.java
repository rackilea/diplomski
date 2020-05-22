import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TestFrame extends JFrame {

    public TestFrame() {
        super("Sample Project");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static class RawHtmlRenderer extends DefaultTableCellRenderer {

        public RawHtmlRenderer() {
            putClientProperty("html.disable", Boolean.TRUE);
        }
    }

    public static void main(String[] str) {
        Object[][] rowData = new Object[][] {
                { "test", "<html><i>something<b>bold</b></i></html>" },
                { "test", "test" }, { "test", "123" } };
        String[] header = new String[] { "Column 1", "Column 2" };
        JTable table = new JTable(rowData, header);
        TestFrame frame = new TestFrame();
        table.getColumnModel().getColumn(1).setCellRenderer( new RawHtmlRenderer() );
        frame.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setVisible(true);
    }

}