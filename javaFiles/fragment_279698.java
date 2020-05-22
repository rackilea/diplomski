System.out.println("Correct result:");
rs = con.createStatement().executeQuery(
    "WITH recursive t(f) AS ( "+
    "    SELECT 1             "+
    "    UNION ALL            "+
    "    SELECT t.f + 1       "+
    "    FROM t               "+
    "    WHERE t.f < 10       "+
    ")                        "+
    "SELECT t.f               "+
    "FROM t                   "
);

while (rs.next())
    System.out.println(rs.getInt(1));