waterButton.addActionListener(new ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {                                            
// TODO add your handling code here:
    try{
       Statement st = connectionObject.createStatement();

       // might want to use placeholders here as well
       String query= "SELECT itemName, itemPrice FROM item WHERE itemID = '11111'"; 
       String itemName = " ",itemPrice =" ";  

       ResultSet rs = st.executeQuery(query);

       if(rs != null){
         do { 
           itemName = rs.getString(1);
           itemPrice = rs.getString(2);
        } while (rs.next());
        orderTextArea.setText(itemName);
        orderTextArea.setText(itemPrice);
        }
      } catch (SQLException ex) { 
         System.err.println(new java.util.Date()+" : "+ex.getMessage(); 
      }
});