String name1[] = new String[100];

    int i = 0;
    String query = "select distinct GeneID from gene1";
    PreparedStatement pest = connection.prepareStatement(query);
    ResultSet rs = pest.executeQuery();

    while (rs.next()) {

        name1[i] = rs.getString("GeneID");
        System.out.println(name1[i]);
      i++;
    }

    rs.close();
    pest.close();
}