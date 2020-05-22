@Entity
@Table(name = "vw_users")
public class User {

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

}