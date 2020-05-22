try (Connection connection = DBConnector.getConnection()) {        
     st = connection .prepareStatement(sqlQuery);
     // more code
 } catch (...) {
     // more code
 }