jComboBox.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
Object name=jComboBox.getSelectedItem();

//Make DB connection on name and fetch the details
//Use double vector for fetching data

Vector<Vector<String>> data = new Vector<Vector<String>>();
        data=getDetails();

Stsem.out.println(data);//To print data (for Confirmation that it works fine)
JOptionPane.showMessageDialog(this,data);


private Vector<Vector<String>> getDetails(Object name) {
//DB Connections
PreparedStatement pre = conn.prepareStatement("select * from Table");

ResultSet rs = pre.executeQuery();

while(rs.next())
{
Vector<String> item = new Vector<String>();
item.add(rs.getString(1)); 
item.add(rs.getString(2)); 
...
itemVector.add(item);
}

/*Close the connection after use (MUST)*/
if(conn!=null)
conn.close();

return itemVector;
            }
        });