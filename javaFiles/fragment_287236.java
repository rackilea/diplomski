@Entity
@Table(name = "A_Category")
public class ACategory{

    // dedicated id column, see note(*) below
    @Id
    @Column(name = "id")
    private Long id;

    // foreign key to "A" table
    @ManyToOne
    @JoinColumn(name = "a_id")
    private A a;

    // foreign key to "Category" table
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;

    @Column(name = "amount")
    private Integer amount;

    // no-arg constructor

    // getters & setters
}