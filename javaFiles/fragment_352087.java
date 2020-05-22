@Data
@Entity
@Table(name = "USER", schema = "YOUR_SCHEMA_NAME")
public class User {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Basic
    @Column(name = "LASTLOGIN")
    private Long lastLogin = 0;
}