...

Map <String, List<String>> map = new HashMap <String, List<String>> ();

List<String> b= new ArrayList<String>();
List<String> n= new ArrayList<String>();
List>String> c= new ArrayList<String>();

String sqlQuery = String.format("select * from dates;");

rs = st.executeQuery(sqlQuery);

while (rs.next()) {
    b.add(rs.getString("black") != null ? rs.getString("black") : "");
    n.add(rs.getString("normal") != null ? rs.getString("normal") : "");
    c.add(rs.getString("cheap") != null ? rs.getString("cheap") : "");
}

map.put("b", b);
map.put("n", n);
map.put("c", c);

...