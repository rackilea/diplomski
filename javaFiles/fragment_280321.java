import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    String[] column_name = new String[]{"Col1","Col2"};
    Vector<String[]> list_value=new Vector<String[]>();

    public TableModel() {
    }

    //add just one line the table
    public void add_row(String[] row_values){
        list_value.add(row_values);
    }

    //change the list 
    public void setList(Vector<String[]>list){
        this.list_value=list;
    }



    @Override
    public int getColumnCount() {
        return column_name.length;
    }

    @Override
    public int getRowCount() {
        return list_value.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        return list_value.get(row)[col];
    }

}