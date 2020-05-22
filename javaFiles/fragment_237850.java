String lSql = "insert into modulo (nombre, directorio, parámetros) values (?,?,?)";
PreparedStatement s = conexion.createPrepareStatement(lSql);
s.setString(1,"Test1");
s.setString(2,"c:\backslashes\p");
s.setString(3,"Test3");
s.executeUpdate();