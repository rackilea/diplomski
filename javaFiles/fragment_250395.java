String stm = "SELECT query FROM table_queries WHERE table_id = ?";
pst = con.prepareStatement(stm);
pst.setInt(1, tableID);
rs = pst.executeQuery();
stm = rs.first().getString("query");
pst = con.prepareStatement(stm);
pst.setInt(1, 100);
rs = pst.executeQuery();