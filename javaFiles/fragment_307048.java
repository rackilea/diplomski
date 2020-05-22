jdbc.query(
   "select pest_name, count(pest_name) from sighting group by pest_name",
   new RowMapper<Sighting>() {
     public Sighting mapRow(ResultSet rs, int rowNum) throws SQLException {
            return sighting;
        }      
   });