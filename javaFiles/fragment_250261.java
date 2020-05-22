@Entity
@Table(name = "<entity name>")
public class EcranChamp {

    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "id_ecran", column = @Column(name = 
        "<column name>", nullable = false)),
    @AttributeOverride(name = "id_champ", column = @Column(name = "<column name>", nullable = false)) })
    EcranChampId id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ecran")
    Ecran ecran;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_champ")
    Champ champ; 
   //getters & setters 
 }   


@Embeddable
public class EcranChampId implements Serializable  {   
  @Column(name = "id_champ", nullable = false) 
  private Long id_champ; 
  @Column(name = "id_ecran", nullable = false)  
  private Long id_ecran; 
  //getters & setters 
}