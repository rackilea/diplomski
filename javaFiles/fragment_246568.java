@ReadOnly
@Entity("table1trimmed")
@Table("table1")
public class Table1Trimmed {

    @Id
    private Long id;
    @OneToOne
    @JoinFetch(JoinFetchType.OUTER)
    @JoinColumn(name = "table1_id")
    private Set<Table2> tables2;

}