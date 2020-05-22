@Entity()
@DynamicUpdate()
@Table(schema = "RACQUISTI", name = "RICHIESTA_DI_ACQUISTO")
public class RichiestaDiAcquisto {
 @Id
 @Column(name = "ID_RICHIESTA_ACQUISTO")     
 @SequenceGenerator(name="SEQ_GEN",sequenceName="RICHIESTA_DI_ACQUISTO_SEQ",   allocationSize=1)
 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
 private int id;

 @OneToOne(fetch=FetchType.LAZY, mappedBy = "richiestaDiAcquisto", cascade = {CascadeType.ALL})
 private WorkFlowDetail workFlowDetail;

 .....
}