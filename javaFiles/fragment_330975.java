String sql = "INSERT INTO data
                    (ovogNer,regNum,itemName,note,zHemjee,hvv,
                     hugatsaa,date,totalPay,expirationDate)"
                     + "VALUES"
                     + "(?,?,?,?,?,?,?,?,?,?)";
pst = conn.prepareStatement(sql);       
pst.setString(1, getFullName());  
pst.setString(2, getRegNum());
pst.setString(3, getItemName());
pst.setString(4, getNote());
pst.setInt(5, getzHemjee());
pst.setInt(6, getFee());
pst.setInt(7,  getTime());
pst.setDate(8, java.sql.Date.valueOf(LocalDate.now()));
pst.setDouble(9, getTotalPay());
pst.setDate(10, expirationDate);
pst.executeUpdate();