String val1 = txt_billing2.getText();
...
String val5 = txt_umonth2.getText();

String sql = "SELECT * from airindia_sqlite WHERE BILLING = ? and STATION = ? and INVOICE = ? and AMONTH = ? and UMONTH = ?";
ps = con.prepareStatement(sql);
ps.setObject(1, val1);
...
ps.setObject(5, val5);