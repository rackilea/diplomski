String[] vals1 = request.getParameterValues("Vals");
int count = 0;
String sql = "DELETE FROM AnimeDatabase WHERE ";

for(int i=0; i < vals1.length; i++) {

    if (i>0) sql += " OR "; 
    sql += "ANI_TITLE='" + vals1 + "'";

}

PreparedStatement ps = conn.prepareStatement(sql);
int update = ps.executeUpdate();
count = update;