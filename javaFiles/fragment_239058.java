public void actionPerformed(ActionEvent e) {
     if(e.getSource()==jButton2){
         int viewRow = jTable1.getSelectedRow();
int modelRow = jTable1.convertRowIndexToModel(viewRow);
Object oc=  jTable1.getModel().getValueAt(modelRow, 0);
String vv=oc.toString();
DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
jframe1 regFace =new jframe1();
        try {
            regFace.setSelectedRow(vv);
        } catch (SQLException ex) {
            Logger.getLogger(showp1.class.getName()).log(Level.SEVERE, null, ex);
        }
regFace.setVisible(true);
   }
}