String sql = "SELECT m.member_id, searscc FROM member m, member_attribute ma " +
            "WHERE m.member_number=:memberNumber AND m.ref_club_status IN ('A','S') AND m.member_id=ma.member_id";
String memberNumber = "John Doe";                   //the argument value for the sql above
JdbcTemplate jdbcTemplate = new JdbcTemplate();     //replace this line with your own code to get JdbcTemplate instance.
List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[]{memberNumber}) ;
byte[] tempMemberIds = null;
String tempSearscc = null;
if ((rows != null) || (rows.size() > 0)) {
    for (Map<String, Object> tempRow : rows) {
        tempMemberIds = (byte[])(tempRow.get("member_id"));     //key is your search field in your sql
        tempSearscc = (String)(tempRow.get("searscc"));
        //do your own jobs
    }
} else {
    //do something else
}