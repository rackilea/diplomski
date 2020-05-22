public static String[] listJadlospis() {
        try {
            state = con.createStatement();
            result = state.executeQuery("SELECT NazwaJadlospisu FROM Jadlospis GROUP BY NazwaJadlospisu");

            List<String> nazwaJadlospisu= new ArrayList<String>();
            String[] T_NazwaJadlospisu = null;
            while (result.next()) {
                nazwaJadlospisu.add(result.getString(1))

                // String T_NazwaJadlospisu =
                // result.getString("NazwaJadlospisu");
                // System.out.println("Jadłospis: " + T_NazwaJadlospisu);
            }
            T_NazwaJadlospisu = new String[nazwaJadlospisu.size()];
            T_NazwaJadlospisu = nazwaJadlospisu.toArray(T_NazwaJadlospisu );
            return T_NazwaJadlospisu;
        } catch (SQLException e) {
            System.err.println("Query error.");
        } catch (NullPointerException e) {
            System.err.println("Element not found.");
        }
    }