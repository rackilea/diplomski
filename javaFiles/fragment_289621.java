ArrayList ar=new ArrayList();

 String query = "select distinct GeneID from gene1";
 PreparedStatement pest = connection.prepareStatement(query);
 ResultSet rs = pest.executeQuery();
 while (rs.next()) {
       String id = rs.getString("GeneID");
        ar.add(id);
    }

    rs.close();
    pest.close();
}