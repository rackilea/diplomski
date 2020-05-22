String sql = "INSERT INTO Repondre (col1, col2, col3, col4) VALUES (?, ?, ?, ?)";
PreparedStatement ps = connection.prepareStatement(sql2);
ps.setInt(1, 1);
ps.setInt(2, 1);
ps.setInt(3, resultSet.getInt(1));
RadioButton rb = (RadioButton)q1.getSelectedToggle();
ps.setString(4, rb.getText().toLowerCase());
preparedStatement.executeUpdate();   // NO parameters here