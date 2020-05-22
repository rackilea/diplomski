Class.forName("java.sql.DriverManager");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/stud","root","");
Statement stmt=con.createStatement();
String query="delete from info where rollno="+rn.getText();
int  d = stmt.executeUpdate(query);
if(d>0){
    JOptionPane.showMessageDialog(null,"record deleted successfully!!!");
}
rn.setText("");