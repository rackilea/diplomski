String plsqlBlock =
    "begin " +
    "  update Table1 " +
    "    set val1 = :v1, val2 = :v2 " +
    "    where primary_key = :pk; " +
    "  if sql%rowcount = 0 then " +
    "    insert into Table1 (primary_key, val1, val2) " +
    "      values (:pk, :v1, :v2); " +
    "  end if; " +
    "end;";

CallableStatement cs = connection.prepareCall(plsqlBlock);
cs.setInt("pk", 12345);
cs.setString("v1", "abc");
cs.setString("v2", "def");
cs.execute();