Statement st = conn.createStatement();
String query_st = "INSERT INTO user_info_table VALUES ('"+user_id+"', '"+age+"', "+height+");";
ResultSet rs = st.executeQuery(query_st);
while (rs.next())
{
   System.out.print("Column 1 returned ");
   System.out.println(rs.getString(1));
} rs.close();
st.close();