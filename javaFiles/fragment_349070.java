public List<String> listeEmployee() {
    List<String> list = new ArrayList<>();
    Connection con = dbConn();
    try {
        Statement stm = con.createStatement();

        String query = "SELECT first_name FROM employees";

        ResultSet resultat = stm.executeQuery(requete);
        while (resultat.next()) {
            list.add(resultat.getString("first_name"));
        }
    } catch (Exception e) {
        System.out.println("Exception = " + e);
    }
    return list;
}