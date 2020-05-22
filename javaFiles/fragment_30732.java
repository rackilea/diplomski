@Entity
@Table(name = "tt_traject_ref_toets")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="")
public class ToetsBijTraject implements Serializable, Comparable<ToetsBijTraject> {

@Id
@Column(name = "traject_id")
private int trajectId;

@Id
@Column(name = "toets_id")
private int toetsId;

@ManyToOne
@MapsId("trajectId")
private Traject traject;

@ManyToOne
@MapsId("toetsId")
private Toets toets;