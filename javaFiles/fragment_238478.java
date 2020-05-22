@DatabaseTable(tableName = "accounts")
public class Account {
    @DatabaseField(id = true)
    private String name;

    @DatabaseField(canBeNull = false)
    private String password;   
}