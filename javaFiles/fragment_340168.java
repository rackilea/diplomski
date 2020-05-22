public class Kid {
    private int id;
    private String name;
    private int userId;
    //getters and setters
}

public class KidHolder {
    private List<Kid> kidHolder;
    public KidHolder() {
        kidHolder = new ArrayList<Kid>();
    }
    public void add(Kid kid) {
    }
}

//...

List<Kid> kidList = new ArrayList<Kid>();
try {
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename", "root", "password");
    st = conn.createStatement();
    rs = st.executeQuery("SELECT * FROM tablename");
    //kids records = new kids();
    //int i = 0;
    while (rs.next()) {
        Kid kid = new Kid();
        //records.id[i] = rs.getInt("id");
        //records.name[i] = rs.getString("name");
        //records.user_id[i] = rs.getInt("user_id");
        kid.setId(rs.getInt("id"));
        kid.setName(rs.getInt("name"));
        kid.setUserId(rs.getInt("user_id"));
        System.out.println("id: " + kid.getId() + "name: " + kid.getName() + "user_id" + kid.getUserId());
        kidList.add(kid);
    }
} catch (Exception e) {
    System.err.println("The Error: " + e);
} finally {
    closeResource(rs);
    closeResource(st);
    closeResource(conn);
}
//probably you should return kidList to display it in your view

//method to close the connection
//create two more similar methods to close ResultSet and Statement...
public void closeResource(Connection con) {
    if (con != null) {
        try {
            con.close();
        } catch (SQLException silent) {
            //...
        }
    }
}