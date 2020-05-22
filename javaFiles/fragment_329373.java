public abstract class PersonDao<T extends Person> { 

     abstract T select(int id);

     ...
}

public class UserDao extends PersonDao<User> {

    public User select(int id) throws SQLException {
        // Assuming there is a type column to differentiate between types of Person
        String sql = "SELECT * FROM person WHERE per_id=? and type=?";
        PreparedStatement ps = con.preparedStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, User.class.getName());
        ResultSet rs = ps.executeQuery();
        User user = null;

        if(rs.next()) {
            user = new User();

            user.setId(rs.getInt("per_id"));
            user.setName(rs.getString("per_name"));
        }

        return user;
    }

    ...
}