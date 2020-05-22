@Entity
public class UserDocument {
    // ...
    @ManyToOne
    private User user;

    @ManyToOne
    private User lastModifiedBy;
    // ...
}