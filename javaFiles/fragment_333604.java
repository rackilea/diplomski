private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
{                                         
    String text = countryInput.getText();
    String text2 = capitalInput.getText();
    hashMap.put(text,text2);
    capitalList.setListData(hashMap.values().toArray());
}