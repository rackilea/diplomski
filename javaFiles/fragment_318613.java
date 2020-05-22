List<Integer> classIds = new ArrayList<Integer>();
classIds.add(1);
classIds.add(2);
classIds.add(3);

String sql = "SELECT * FROM T_USER WHERE "+
              "USERNAME LIKE ? AND PASSWORD LIKE ? AND CLASS_ID IN (?)";
jdbcTemplate.query(sql, new Object[]{"%admin%", "%password%", classIds},
                                                         new UserRowMapper());