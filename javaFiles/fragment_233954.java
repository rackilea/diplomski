String sql = "INSERT INTO HARMS(DATE_D, TIME_T, DESCRIPTION, TRANSACTIONID, CREDIT_AMOUNT, DEBIT_AMOUNT, REMAINING, ODAMOUNT, ENTEREDBY, REMARKS)"+
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
ps = cn.prepareStatement(sql);
ps.setString(1, value1[0]);
ps.setString(2, value1[1]);
ps.setString(3, value[1]);
ps.setString(4, value[2]);
ps.setFloat(5, Float.parseFloat(value[3]));
ps.setFloat(6, Float.parseFloat(value[4]));
ps.setFloat(7, Float.parseFloat(value[5]));
ps.setFloat(8, Float.parseFloat(value[6]));
ps.setString(9, value[7]);
ps.setString(10, value[8]);
int c=ps.executeUpdate();