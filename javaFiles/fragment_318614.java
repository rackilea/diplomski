String sql = "SELECT * FROM T_USER WHERE "+
           "USERNAME LIKE :uname AND PASSWORD LIKE :passwd AND CLASS_ID IN (:ids)";
 Map<String, Object> namedParameters = new HashMap<String, Object>();
 namedParameters.put("uname", "%admin%);
 namedParameters.put("passwd", "%password%");
 namedParameters.put("ids", classIds);
 List result = namedParameterJdbcTemplate.query(sql, namedParameters, 
                                                             new UserRowMapper());