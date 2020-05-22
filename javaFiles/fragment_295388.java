public class TableTest {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JTable table = new JTable();
        JScrollPane scroll = new JScrollPane(table);
        String[] titles = {"System Code","Domain Name","Organizational Unit","Organization Name"};
        TableColumn[] columns = new TableColumn[titles.length];
        for(int i=0; i<titles.length; i++)
        {
            TableColumn column = new TableColumn(i);
            column.setHeaderValue(titles[i]);
            column.setWidth(150);
            column.setResizable(true);
            columns[i] = column;
            table.addColumn(column);//since we add this here, no real point in keeping
                                    //the columns in an array tbh anymore
        }
        f.add(scroll);
        f.setSize(500, 500);
        f.setVisible(true);
    }
}