public List<Garaz> getAllGaraz() throws SQLException {
    List<Garaz> garazList = new ArrayList<Garaz>();
    try (
        Connection con = getDBConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "SELECT Garaz.G_ID, /* other garaz columns */ " +
                   "Auta.A_Id /*other auta columns */\n" +
            "FROM Garaz\n" +
            "LEFT JOIN Auta\n" +
            "ON Garaz.G_Id=Auta.G_Id\n" +
            "ORDER BY Garaz.G_Id");
    ) {
        Garaz currentGaraz = null;
        while (rs.next()) {
            int garazId = rs.getInt("G_ID");
            // Create Garaz only if it is different
            if (currentGaraz == null || currentGaraz.getId() != garazId) {
                // retrieve other columns
                currentGaraz = new Garaz(g_id /* + other garaz columns */);
                garazList.add(currentGaraz);
            }

            int a_id = rs.getInt("A_Id");
            // replacement of your condition of a_id != 0
            // 0 could be a valid value, check for null instead
            if (!rs.wasNull()) {
                // retrieve other columns
                Auto auta = new Auta(a_id /* + other auta columns */);
                // The list of Auta is part of the garaz
                currentGaraz.addAuta(auta);
            }
        }
        return garazList;
    }
}

public class Garaz {
    private final List<Auta> autaList = new ArrayList<Auta>();
    private final int id;

    public Garaz(int g_id /* + other fields*/) {
        id = g_id;
    }

    public int getId() {
        return id;
    }

    public void addAuta(Auta auta) {
        autaList.add(auta);
    }

    public List<Auta> getAutaList() {
        return new ArrayList<Auta>(autaList);
    }
}