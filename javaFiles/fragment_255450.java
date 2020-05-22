List<Integer> result = getTemplate().execute(getSql("create"), params, new PreparedStatementCallback<List<Integer>>(){
        @Override  
        public List<Integer> doInPreparedStatement(PreparedStatement ps)  
                throws SQLException, DataAccessException {  
            ResultSet rs = ps.executeQuery();
            List<Integer> id = new LinkedList<Integer>();

            while (rs.next())
                id.add(rs.getInt(1));

            rs.close();
            return id;
        }
        });
        return result.get(0);