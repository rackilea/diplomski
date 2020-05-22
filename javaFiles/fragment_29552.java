private ResourceBundle reader = null;
 try{ 
     reader = ResourceBundle.getBundle("dbconfig.properties");
     Connection conn=DriverManager.getConnection(reader.getString("db.url"),reader.getString("db.username"),reader.getString("db.password"));
 }catch(Exception e){
}