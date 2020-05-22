@Entity
public class Invoice{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default false")
    private Boolean archived = Boolean.FALSE;

    @ManyToOne(mappedBy = "invoices")
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGN KEY (archived, user_id) REFERENCES user(archived, id) ON DELETE RESTRICT ON UPDATE CASCADE"))
    private User user;

    // Setters & Getters
}