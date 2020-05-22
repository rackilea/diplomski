while(rs.next()){
    String value = rs.getString("expert1");
    textField1.setText(value);        
    try {
          Thread.sleep(3000);
    } catch(Exception e) {}
}