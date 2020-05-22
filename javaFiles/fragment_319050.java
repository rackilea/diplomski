String sqlUser = e.getActionCommand();
    String sql;
    PreparedStatement stmt;
    try{
        int id = Integer.parseInt(textField_1.getText());
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
                        java.sql.Date date2 = new java.sql.Date(System.currentTimeMillis());
        if(sqlUser.equals("Save Record"))
                    {
                        ResultSet rs;

                        sql = "INSERT INTO table_name (name, ID, result, date, date2) values (?,?,?,?,?)";
                        stmt = con.prepareStatement(sql);
                        stmt.setString(1, textField.getText());
                        stmt.setInt(2, id);
                        stmt.setString(3, textField_2.getText());
                        stmt.setDate(4,date );
                        stmt.setDate(5,date2);
                        // OLD: rs = stmt.executeQuery();
                        // OLD: updateUI(rs);
                        stmt.executeUpdate();
                        updateUI(id,  textField.getText(),textField_2.getText(),date,date2 );
                        // OLD: con.commit();
                    }
        else if(sqlUser.equals("Save Update"))
                    {
                        ResultSet rs;
                        sql = "UPDATE table_name SET result = ? , date = ?, date2 = ? WHERE name = ? AND ID = ?";
                        stmt = con.prepareStatement(sql);
                        stmt.setString(4, textField.getText());
                        stmt.setInt(5, id);
                        stmt.setString(1, textField_2.getText());
                        stmt.setDate(2, date);
                        stmt.setDate(3, date2);
                        // OLD: rs = stmt.executeQuery();
                        // OLD: updateUI(rs);
                        stmt.executeUpdate();
                        updateUI(id,  textField.getText(),textField_2.getText(),date,date2 );
                        // OLD: con.commit();
                    }
    } catch (SQLException err)
    {
        JOptionPane.showMessageDialog(null,err.getMessage());
    }

The updateUI method is as follows:

    public void updateUI(int id, String name, String result, Date date, Date date2)
        {
            try
            {
                String strCDate = dateFormat.format(date);//rs.getDate("date"));
                String strLADate = dateFormat.format(date2);//rs.getDate("date2"));

                textField.setText(name);//rs.getString("name"));
                textField_1.setText(id+"");//Integer.toString(rs.getInt("ID")));
                textField_2.setText(result);//rs.getString("result"));
                lblCalculationDate.setText("Date: " + strCDate);
                lblLastAccessDate.setText("Date2: " + strLADate);
            }
            catch(SQLException err)
            {
                JOptionPane.showMessageDialog(null,err.getMessage());
            }
        }