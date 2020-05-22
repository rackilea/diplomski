String sql = "SELECT DISTINCT(month) FROM table01 WHERE day='"+jComboBox1.getSelectedItem()"';

            ResultSet res = stat.executeQuery(sql);

            while (res.next()) {
                String val = res.getString(0);
                jComboBox2.addItem(val);
            }