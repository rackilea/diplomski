@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")
public class XmppUser {
    @Id
    private java.lang.String username;
    //...

    }