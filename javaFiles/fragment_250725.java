String sql = "SELECT FULLNAMES FROM CUSTOMER WHERE ADDRESS = ? OR ADDRESS = ?";

Map<Integer,Object> param = new HashMap<>();
param.put(1,"NEW YORK");
param.put(2,"CHICAGO");

Database db = new Database(sql);
db.setParameters(param);
List customers = db.processQuery();