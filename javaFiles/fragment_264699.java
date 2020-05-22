@UniqueKey(columnNames={"userName"})
// @UniqueKey(columnNames={"userName", "emailId"}) // composite unique key
//@UniqueKey.List(value = {@UniqueKey(columnNames = { "userName" }), @UniqueKey(columnNames = { "emailId" })}) // more than one unique keys
public class User implements Serializable {

    private String userName;
    private String password;
    private String emailId;

    protected User() {
        super();
    }

    public User(String userName) {
        this.userName = userName;
    }
        ....
}