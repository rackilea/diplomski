public class Test {
public static void main(String[] args) {
    int rowIndex = MyTable.getSelectedRow();
    String name = String.valueOf(MyTable.getValueAt(rowIndex, 1));

    try {
        Connection con;
        Statement stmt;


        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//abdul//Desktop/StudentDatabase.accdb");


        stmt = con.createStatement();

        int result = stmt.executeUpdate("delete from StudentDatabase where CustomerName = '"+name+"'" );

        if(result!=1){
            JOptionPane.showMessageDialog(null,"No record exists related to "+name);
        }



        stmt.close();
        con.close();
    }
    catch(Exception e) {
        e.printStackTrace();
    }
}