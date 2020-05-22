String strUpdate = "update ShopSystem.Grocery set g_name= ?, g_price=?   where g_id = ?";
stmtUpdate = con.prepareStatement(strUpdate);
stmtUpdate.setString(1,g_name);
stmtUpdate.setString(2,g_price);
stmtUpdate.setInt(3,g_id);
int c2 = stmtUpdate.executeUpdate();