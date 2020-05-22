final Sql sampleSql 
       = new Sql("SELECT * FROM Table WHERE a=@int_a AND b=@str_b)

StatementImpl stat = new StatementImpl(conn, sampleSql);

stat.setInt("int_a", int_value);
stat.setString("str_b", not_null_string_value);
stat.setString2("str_b", null_or_string_value);
// setLong, setFloat, setDouble, setDate, ...