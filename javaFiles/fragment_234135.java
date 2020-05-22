public List<UserBean> getdata()  {
List<UserBean> users = null;

    users = jdbcTemplate.query("select username from customer", new ResultSetExtractor<List<UserBean>>() {

        @Override
        public List<UserBean> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<String> usersTemp = new ArrayList<>();
            while(rs.next()) {
                UserBean ub = new UserBean();
                ub.setUsername(rs.getString(1));
                usersTemp.add(ub);
            }
            return usersTemp;
        }
    });
    return users;