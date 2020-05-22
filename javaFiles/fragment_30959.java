StringBuilder sql = new StringBuilder()
sql.append("SELECT USER_ID, USER_NAME, REGISTRATION_ID, MOBILE_NUMBER FROM USER WHERE MOBILE_NUMBER IN (");

for(String mobileNumber: mobileNumbers) {
      sql.append("?,");
    }
sql.append(")");

//use this to remove the extra comma at the end of your IN() clause
String query = sql.toString().replace(",)", ")");

//Convert your list to array for use with jdbcTemplate
Object[] params = mobileNumbers.toArray();

// if you have an entity class to map the resultset to, I suggest you use BeanPropertyRowMapper
List<YourEntityClass> list = jdbcTemplate.query(query, params, new BeanPropertyRowMapper<YourEntityClass>(YourEntityClass.class));