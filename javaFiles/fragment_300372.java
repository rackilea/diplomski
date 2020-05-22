@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "friendship", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "friend_id")
    @Column(name = "start_date")
    private Map<Long, Date> friendshipMap;

    ... getters/setters ...

}