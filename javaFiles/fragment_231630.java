static final Sql EXAMPLE_SQL 
          = new Sql("SELECT EXAMPLE FROM DATA WHERE EXAMPLE IN (@example_array)");

StatementImpl stat = new StatementImpl(GestionBDD.getConexionBD(), EXAMPLE_SQL);

stat.setIntArray("example_array", new int[] {1, 2, 3} );
// OR stat.setIntArray("example_array", 1, 2, 3);

ResultSet rs = stat.executeQuery();

while (rs.next()) {
    // DO THINGS 
}

rs.close(); stat.close();