public Jugador[] buscarDiez() {

    Jugador[] diez = new Jugador[9];
    try {
        orden = conexion.createStatement();
        String sql = "SELECT user, score FROM player ORDER BY score LIMIT 9";
        rs = orden.executeQuery(sql);

        int i = 0;

        while (rs.next()) {
            diez[i] = new Jugador();// create new object instance
            diez[i].setUser(rs.getString("user"));
            diez[i].setScore(rs.getInt("score"));

            i = i + 1;
        }
    }
    return diez;
}