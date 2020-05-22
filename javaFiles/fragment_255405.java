int deleted = st.executeUpdate(sql); 

if(deleted > 0)
 JOptionPane.showMessageDialog(null , "Deleted successfully");
else
 JOptionPane.showMessageDialog(null , "Nothing deleted");