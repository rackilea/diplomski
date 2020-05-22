String rq1 = "SELECT region,ACTELS FROM rg";

st1 = conn.createStatement();
rs1 = st1.executeQuery(rq1);  

comboBox_ACTELS = new JComboBox<String>();
comboBox_gouver = new JComboBox<String>();

while (rs1.next()) {
  String m1= rs1.getString("region");
  String m2= rs1.getString("ACTELS");
  //comboBox_gouver.setModel(new DefaultComboBoxModel<String>(new String[] {m1}));
  //comboBox_ACTELS.setModel(new DefaultComboBoxModel<String>(new String[] {m2}));
   comboBox_gouver.addItem(m1);
   comboBox_ACTELS.addItem(m2);
    nbp ++;
}