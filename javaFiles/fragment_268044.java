final MyInstance m = new MyInstance();
jdbcTemplate.query("select * from table where name = ? and weight= ?", 
    new PreparedStatementSetter(){
        @Override
        public void setValues(PreparedStatement ps){
            ps.setString(1, m.getName);
            ps.setInt(2, m.getWeight);
        }
    }, myResultSetExtractor);