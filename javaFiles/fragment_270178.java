@Table(name = "IApp")
public class IAppEntity {

    @Id
    private String packageName;

    @ManyToOne
    @JoinColumn(referencedColumnName="packageName")
    private IAppsFriends friends;

    // ... rest of code

}