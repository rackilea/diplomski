String sql="Select Sum(Price) as sumprice from sold";
                          pst=con.prepareStatement(sql);
                          rs=pst.executeQuery();
                          if(rs.next()){
                              String sum = rs.getString("sumprice");
                              textField_2.setText(sum);