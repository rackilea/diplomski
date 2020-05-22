@Entity
    @Table(name = "A")
    public class A {

        @GenericGenerator(name = "idGenerator", strategy = "increment")
        @Id
        @GeneratedValue(generator = "idGenerator")
        @Column(name = "id", unique = true, nullable = false)
        private Integer id;

        @Column(name = "value_a")
        private String valueA;
        @joinTable(name="A_B_relation",joinColumns=@JoinColumn(name="a_id"),
                   inverseJoinColumns=@JoinColumn(name="b_id"))
        @ManyToMany(fetch=FetchType.EAGER)
        private List<B> b;
    }