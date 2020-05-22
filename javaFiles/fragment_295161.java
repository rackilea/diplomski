public List<String> yourRandomQuery(String columnName) {
    Connection con = null;
    ResultSet rs = null;
    List<String> results = new ArrayList<String>();
    try {
        String baseQuery = "SELECT DISTINCT %s AS call FROM tablename";
        con = ...; //retrieve your connection
        ResultSet rs = stmt.executeQuery(String.format(baseQuery, columnName));
        while(rs.next()) {
            results.add(rs.getString(1));
        }
    } catch (SQLException e) {
        //handle your exception
        e.printStacktrace(System.out);
    } finally {
        closeResource(rs);
        closeResource(con);
    }
    return results;
}

//both Connection and ResultSet interfaces extends from AutoCloseable interface
public void closeResource(AutoCloseable ac) {
    try {
        if (ac != null) {
            ac.close();
        }
    } catch (Exception e) {
        //handle this exception as well...
    }
}

public void someMethod() {
    //retrieve the results from database
    List<String> results = yourRandomQuery(jTextField.getText());
    //consume the results as you wish
    //basic example: printing them in the console
    for(String result : results) {
        System.out.println(result);
    }
}