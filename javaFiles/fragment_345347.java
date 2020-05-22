// con is your active connection

String sqlStatement = "UPDATE MY_TABLE SET COL_1=?, COL_2=? where BOOKMARKID_ACT=? AND DIMID_ACT=?";
PreparedStatement prest = con.prepareStatement(sqlStatement);
prest.setString(1, valueFirstParam);
prest.setString(2, valueSecondParam);
prest.setString(3, valueThirdParam);
prest.setString(4, valueFourthParam);
prest.executeUpdate();