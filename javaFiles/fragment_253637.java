@Entity
public class A {
    @Id
    private Long id;
    @OneToMany (mappedBy="parentA")
    private Collection<B> allBs;

    @Formula("(select max(b.some_date) from B b where b.a_id = id)")
    private Date latestBDate;
}