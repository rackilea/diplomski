public static void CheckUpdateUserSQL(String sqluser) throws ClassNotFoundException {
    selectSQL(sqluser);
    if (id.equals("thisuserdoesntexistforsure")) {
        InsertSQL(sqluser);
    } else {
        String sql = "UPDATE USERS set TOTALTIME = ?, LASTLOGIN = ?, "
                + "TOTALCOIN = ?, ISONLINE = 0 where NAME = ?";
        String sql2 = "UPDATE USERS set LASTLOGIN = ? where NAME=?";
        int progress = CurrentTime - lastlogin;
        int totalprogress = progress + totaltime;
        if (progress < 60 && progress > 0) {
            if (isonline == 1) {
                coins = progress / 4;
            } else {
                coins = progress / 5;
            }
            int coinsincrease = (int) Math.ceil(coins);
            int coinstotal = coinsamount + coinsincrease;
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db");
                    PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, totalprogress);
                ps.setInt(2, CurrentTime);
                ps.setInt(3, coinstotal);
                ps.setString(4, sqluser);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db");
                    PreparedStatement ps = conn.prepareStatement(sql2)) {
                ps.setInt(1, CurrentTime);
                ps.setString(2, sqluser);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}