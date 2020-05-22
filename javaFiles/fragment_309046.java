import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


public class TestFrame extends JFrame{

    public TestFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        pack();
        setVisible(true);
    }

    private void init() {
        JTable table = new JTable(new Object[][]{
                {1,"doc"},
                {2,"xlsx"},
                {3,"abc"}
        },new Object[]{"nmb","extension"});

        table.getColumnModel().getColumn(1).setCellRenderer(getRenderer());
        add(new JScrollPane(table));
    }


    private TableCellRenderer getRenderer() {
        return new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component tableCellRendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,row, column);
                if("doc".equals(value)){
                    tableCellRendererComponent.setBackground(Color.YELLOW);
                } else  if("xlsx".equals(value)){
                    tableCellRendererComponent.setBackground(Color.GREEN);
                } else {
                    tableCellRendererComponent.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
                }
                return tableCellRendererComponent;
            }
        };
    }

    public static void main(String... strings) {
        new TestFrame();
    }
}