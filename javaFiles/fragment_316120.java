@Entity
@Table(name = "table_b")
public class EntityB {
...
//    @Column(name = "table_a_id")
//    private Long aId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_a_id")
    private TableA tableA;
...
}