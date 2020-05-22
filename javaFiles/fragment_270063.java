PreparedStatement stmt = connection.prepareStatement(
        "merge table_1 t1 " +
        "using (select 'testvalue' as col1) t2 " +
        " on t1.col1 = t2.col1 " +
        " when not matched by target then " + 
        " insert (col1) values('testvalue'); "  
        ,Statement.RETURN_GENERATED_KEYS);

int out = stmt.executeUpdate();
System.out.println("Return:  " + out);  
ResultSet rs = stmt.getGeneratedKeys();
if (rs.next()) {
    System.out.println("value:  " + rs.getLong(1));
}