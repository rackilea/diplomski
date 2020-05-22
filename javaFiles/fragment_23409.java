@Entity
@Table(name = "focusoc_conjunction")
public class ConjunctionAdapter extends Adapter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long         id;

  @ManyToOne
  @JoinColumn(name = "target_id")
  private OrbitAdapter target;

  @ManyToOne
  @JoinColumn(name = "chaser_id")
  private OrbitAdapter chaser;

  ...
  public OrbitAdapter getTarget(){
    return target;
  }
  public void setTarget(OrbitAdapter target){
    this.target = target;
  }
  public String getChaserId(){
    return chaserId;
  }
  public void setChaser(OrbitAdapter chaser){
    this.chaser = chaser;
  }

  ...

}