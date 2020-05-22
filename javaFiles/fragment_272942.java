@DatabaseTable(tableName = "subscriptions")
public class Subscription {
    @DatabaseField(generatedId = true)
    private int sub_id;
    @DatabaseField(index = true, uniqueCombo=true, foreign = true, foreignColumnName = "gcm_id")
    private User user;
    @DatabaseField(index = true, uniqueCombo=true, foreign = true, foreignColumnName = "id")
    private Category category;
    //other stuff in the class
}