@Entity
@Table(name="ENCAISSEMENT_ETAT_ENCAISSEMENT")
@IdClass(EncaissementEtatEncaissementId.class)
public class EncaissementEtatEncaissement {

  @Temporal(TemporalType.DATE)
  @Column(name="DATE_ETAT_ENCAISS")
  private Date dateEtat;

  @Id
  @ManyToOne
  @JoinColumn(name="ID_ETAT_ENCAISSEMENT", referencedColumnName="ID_ETAT_ENCAISSEMENT")
  private Etat_Encaissement etat_encaissements;

  @Id
  @ManyToOne
  @JoinColumn(name="ID_ENCAISSEMENT", referencedColumnName = "id")
  private Encaissement encaissement;
..
}