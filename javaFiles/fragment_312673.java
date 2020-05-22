private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) 
{                       
    System.out.println("jComboBox1 : " + jComboBox1);                   
    String support = (String)jComboBox1.getSelectedItem();
    System.out.println("support : " + support);
    System.out.println("league : " + league);
    league.setLeagueName(support);
}