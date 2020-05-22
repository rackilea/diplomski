@DatabaseTable(tableName = "users")
public class User {
    @DatabaseField(generatedIdSequence = "users_id_seq", useGetSet = true)
    private long id;

    @DatabaseField(useGetSet = true)
    private Date cdate;

    @DatabaseField(useGetSet = true)
    private Date mdate;

    @DatabaseField(canBeNull = false, useGetSet = true)
    private String name;

    @DatabaseField(canBeNull = false, useGetSet = true)
    private String email;

    @DatabaseField(canBeNull = false, useGetSet = true)
    private String password;

    @DatabaseField(columnName = "avatar_id", foreign = true, useGetSet = true)
    private Avatar avatar;

    public User() {
        // ORMLite needs a no-arg constructor 
    }

    // Getter and setter methods.
}