list = jdbcTemplate.query(sql, new Mapper()); // store all retrieved data to list

    if (list != null) {
        for (A c : (List<A>) list) {
            c.setId("123");  // overwrite the id
            c.setState("Active");             
        }
    }