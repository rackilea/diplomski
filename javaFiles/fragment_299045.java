@Entity()
@Table(schema = "RACQUISTI", name = "WORKFLOW_DETAIL")
public class WorkFlowDetail {
    @GenericGenerator(name = "generator", strategy = "foreign",
        parameters = @org.hibernate.annotations.Parameter(name = "property", value = "richiestaDiAcquisto"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID_RICHIESTA_ACQUISTO", unique = true, nullable = false)
    private int idRichiestaAcquisto;



  @OneToOne(fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn
  private RichiestaDiAcquisto richiestaDiAcquisto;

  ....

}