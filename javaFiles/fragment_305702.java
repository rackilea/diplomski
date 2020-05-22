ResultSet resultado = null;
String statement1 = "SELECT dblink_exec('hostaddr=xxx.xx.xxx.xxx port=5432 dbname=bdname user=myuser password=mypass connect_timeout=2','INSERT INTO table3(field4) VALUES (5)') AS result";
String statement2 = "SELECT dblink_exec('hostaddr=xxx.xx.xxx.xxx port=5432 dbname=bdname user=myuser password=mypass connect_timeout=2','UPDATE table1 SET field2 = field2 + 3.0 WHERE field1 = 16436') AS result";
    try {
        // set auto-commit to false, to indicate start of transaction
        conexion.setAutoCommit(false);

        // run whatever queries you want on the connection, in a transaction, e.g. :
        Statement sentencia = conexion.createStatement();
        resultado = sentencia.executeQuery(sql);

        //manually commit the transaction when you're done
        conexion.commit();

        return resultado;
    } catch (SQLException ex) {
        System.out.println("Error Consulta:" + ex);

        // ensure transaction is rolled-back in case of error. (note: you might want to add an NPE check here
        con.rollback();
        return null;
    } finally {
        // close any statements / preparedStatements, etc. Note you MUST do this in the finally block, to ensure your connection won't stay in transaction.
        con.setAutoCommit(true);
    }