public class PersonDao<T extends Person> { 

     private Class<T> type;

     public PersonDao(Class<T> type) {
         this.type = type;
     }

     public T select(int id) {
        String sql = "SELECT * FROM person WHERE per_id=? and type=?";
        PreparedStatement ps = con.preparedStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, type.getName());
        ResultSet rs = ps.executeQuery();
        T t = null;

        if(rs.next()) {
            t = type.newInstance();

            t.setId(rs.getInt("per_id"));
            t.setName(rs.getString("per_name"));
        }

        return t;
     }

     ...
}