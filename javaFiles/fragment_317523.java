@Entity
@Table(name="loans")
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "total")
    private Long sum;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    //...
}