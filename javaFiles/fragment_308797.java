public static List<Matiere> getAll()
{
    List<Matiere> matiere = new ArrayList<>();

    try
    {
        String sql = "SELECT * FROM matiere";
        Connection con = Connect.getConnection();
        PreparedStatement statement = con.prepareStatement(SQL);
        ResultSet rs = statement.executeQuery(SQL);

        while(rs.next()) {
            Matiere m = new Matiere();

            //Here add your database fields
            m.setId(rs.getString("id"));
            m.setLibelle(rs.getString("libelle"));
            matiere.add(m);
        }
    }
    catch(SQLException e) {
        // Log any exceptions ...
    }
    finally() {
        // Always close your JDBC resources
        try {
            if (statement != null) {
                statement.close();
                statement=null;
            }
        }
        catch(SQLException e) {
            // Couldn't close statement
            }
    }
    return matiere;
}