import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class SortJTable {

    public static void main(String[] args) {
        final String[] columns = getTableColumns();
        final Object[][] tableData = getTableValues();
        TableModel model = new DefaultTableModel(tableData, columns);

        final JTable table = new JTable(model)
        {
            @Override
            public int getRowCount()
            {
                int rows = (int)getClientProperty("rows");

                if (rows == -1)
                    return getModel().getRowCount();
                else
                    return rows;
            }
        };
        table.setAutoCreateRowSorter(true); // Make it possible to column-sort

        final JComboBox<String> box = new JComboBox<String>();
        box.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(box.getSelectedIndex() == 0)
                {
                    System.out.println("SHOW ALL");
                    table.putClientProperty("rows", new Integer(-1));
                }
                else if(box.getSelectedIndex() == 1)
                {
                    System.out.println("SHOW 5");
                    table.putClientProperty("rows", new Integer(5));

                }
                else
                {
                    System.out.println("SHOW 7");
                    table.putClientProperty("rows", new Integer(7));
                }

                table.revalidate();
                table.repaint();
            }
        });
        box.addItem("Show all rows");
        box.addItem("Show 5 first rows");
        box.addItem("Show 7 first rows");

        JFrame frame = new JFrame();
        frame.add(new JScrollPane(table));
        frame.add(box, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private static String[] getTableColumns(){
        String[] columns = new String[10];
        for(int i=0; i<10; i++)
            columns[i] = "col"+i;
        return columns;
    }

    private static Object[][] getTableValues(){
        Object[][] tableData = new Object[10][10];
        for(int i=0; i<tableData.length; i++){
            for(int j=0; j<tableData[0].length; j++){
                tableData[i][j] = i+""+j;
            }
        }
        return tableData;
    }
}