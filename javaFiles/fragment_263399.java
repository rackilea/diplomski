private String test() throws SQLException {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    try (Connection con = L2DatabaseFactory.getInstance().getConnection()) {
        try (PreparedStatement stm1 = con.prepareStatement(
                "SELECT char_name,accesslevel,online FROM characters WHERE obj_Id in (SELECT owner_id FROM items WHERE item_id=57 order by count desc limit 10)")) {
            ResultSet rSet = stm1.executeQuery();
            while (rSet.next()) {
                count++;
                int accessLevel = rSet.getInt("accesslevel");
                if (accessLevel > 0) {
                    continue;
                }
                String pl = rSet.getString("char_name");
                int online = rSet.getInt("online");
                String status = online == 1 ? "<font color=\"00FF00\">Online</font>" : "<font color=\"FF0000\">Offline</font>";
                sb.append("<tr><td>" + pl + "</td><td>" + count + "</td><td>" + status + "</td></tr>");
            }
        }
    } catch (Exception e) {
        Logger.getLogger("test").log(Level.SEVERE, "Error", e);
    }
    return sb.toString();
}