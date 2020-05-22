private void addComboColumnData() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(conURL);
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT id, name FROM categories");            
            comboCategory.removeAllItems();
            comboCategory.addItem(""); // blank value.
            categoryMap.clear();
            while(rs.next()){
                String name = rs.getString("name");
                comboCategory.addItem(name);
                categoryMap.put(rs.getInt("id"), name);
            }           
            rs.close();
            conn.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.toString());
            e.printStackTrace();
        }
    }