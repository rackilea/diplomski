@Document(collection = "user")
@TypeAlias("user")
@CompoundIndexes({
    @CompoundIndex(name = "contact_email", def = "{ 'contact.mail': 1 }", unique = true)
})
public class User {
    @Id
    private ObjectId id;
    private Contact info = new Contact();
}