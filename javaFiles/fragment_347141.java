String sql = "update budgetreport" +
                " set sales=?, cogs=?" + 
                " where quarter=?";

PreparedStatement preparedStatement = conn.prepareStatement(sql);
preparedStatement.setString(1, salesText.getText());
...
preparedStatement.executeUpdate();