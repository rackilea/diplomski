public Opportunity[] getOpportunitiesBy(String title, String zipcode, double miles) {
   String sql = "select * from opportunities where title = :title and zipcode in (:zips)";
   title = ""+Constants.TITLES_MAP.get(title.toLowerCase());
   String[] nearbyZipcodes = getZipcodesWithinRadius(zipcode, miles);

   Map<String, Object> params = new HashMap<>();
   params.put("title", nearbyZipcodes);
   params.put("zips", near)

   return this.jdbcTemplate.query(sql, params, new RowMapper<Opportunity>() {
       public Opportunity mapRow(ResultSet rs, int rowNum) throws SQLException {
           Opportunity temp = new Opportunity();
           System.out.println("this");
           String[] candidateIds = rs.getString("candidateIds").split(",");
           temp.setCandidateIds(Utilities.StringToIntArray(candidateIds));
           temp.setCompany(rs.getString("company"));
           temp.setId(rs.getLong("id"));
           temp.setHtml(rs.getString("post_data"));
           temp.setZipcode(rs.getString("zipcode"));
           temp.setTitle(rs.getInt("title"));
           try {
               temp.setLogoImg(new URI(rs.getString("logo_img")));
           } catch (Exception e) {
           }
           return temp;
       });

}