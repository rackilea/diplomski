private void showCategory() {
        cmbMCat.removeAllItems();
        try {
            PreparedStatement stmt; //Used Prepared statement
            String sql = "SELECT * FROM menu_cat WHERE type_id = ?";
            stmt = con.prepareStatement(sql);

            if (type.equals("Drink")) {
                stmt.setString("TY01");    
            } else {
                stmt.setString("TY02");
            }
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    cmbMCat.addItem(rs.getString("menu_cat"));
                }

            }
        } catch (Exception e) {

        }
    }