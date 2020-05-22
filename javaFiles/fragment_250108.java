@Repository
public class SomeDAOImpl implements SomeDAO{

        @Override
        public User getSomething(String username){
            User user = getJdbcTemplate().queryForObject("SELECT * FROM USER WHERE USERNAME = ?",
            new Object[] { username },
            new UserMapper()
            );
           return user;
        }

        private class UserMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("ID"));
            user.setUsername(rs.getString("USERNAME"));
            user.setName(rs.getString("NAME"));
            return user;
        }

     }

}