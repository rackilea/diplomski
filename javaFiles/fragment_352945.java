public class Arsti2 {
JFrame main = new JFrame("Ārst");
JPanel tP = new JPanel();
JPanel bP = new JPanel();
JButton one = new JButton("Test");
JTable table = new JTable();
DefaultTableModel model;
Vector columnNames = new Vector();
Vector data = new Vector();

Arsti2() {
    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    main.setSize(840,300);
    try {

        reloadData();
        model = new DefaultTableModel(data,columnNames);
        table.setModel(model);
        //model.fireTableDataChanged();
        tP.add(table);
        bP.add(one);
        main.add(tP,BorderLayout.NORTH);
        main.add(bP,BorderLayout.SOUTH);
    } catch(Exception e) {
        e.printStackTrace();
    }
    main.setVisible(true);
    one.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evnt1) {
            try {
                reloadData();
                 model.fireTableDataChanged();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    });
}

private void reloadData() throws ClassNotFoundException, SQLException {
    columnNames.clear();
 data.clear();
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    String Base = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)}; DBQ=SL.mdb";
    Connection con = DriverManager.getConnection(Base,"","");
    Statement st = con.createStatement();
    ResultSet res = st.executeQuery("SELECT * FROM Arsti");
    ResultSetMetaData rsmd = res.getMetaData();
    int column = rsmd.getColumnCount();         
    columnNames.addElement("ID");
    columnNames.addElement("Vards");
    columnNames.addElement("Uzvards");
    columnNames.addElement("Dzimums");
    columnNames.addElement("Personas kods");
    columnNames.addElement("Telefona numurs");
    columnNames.addElement("Nodalas ID");
    columnNames.addElement("Amata ID");
    while(res.next()) {
        Vector row = new Vector(column);
        for(int i=1; i<=column; i++) {
            row.addElement(res.getObject(i));
        }
        data.addElement(row);
    }
}

public static void main(String[] args) {
    new Arsti2();
}
}