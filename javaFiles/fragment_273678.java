String sql = "SELECT DISTINCT(year) FROM table01 WHERE month='"+jComboBox2.getSelectedItem()+"' AND day='"+jComboBox1.getSelectedItem()+"'"; 

        ResultSet res = stat.executeQuery(sql);

        while (res.next()) {
            String val = res.getString("0");
            jComboBox3.addItem(val);
        }