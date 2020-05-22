if (search != null && !search.isEmpty()) {   
            searchFragment = " AND (UPPER(field1) LIKE :search" +
                              " OR UPPER(field2)  LIKE :search)";           
  }


  sql = this.prepareQuery(sql, ImmutableMap.of(
      "searchConstraints", searchFragment,
      "dateStartFragment", dateStartFragment
  ));


   Query query = this.sessionFactory.getCurrentSession()
                .createSQLQuery(sql) 
   //more query here



 if (search != null && !search.isEmpty()) {    
     query.setString("search", "%" + search.toUpperCase() + "%");            
 }



public String prepareQuery(String queryString, Map<String, String> templateVars) {
     ST stringTemplater = new ST(queryString, '$', '$');

      for (String key : templateVars.keySet()) {
          stringTemplater.add(key, templateVars.get(key));
      }

      String renderedQuery = stringTemplater.render();
      return renderedQuery;
}