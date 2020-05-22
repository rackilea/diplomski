@Entity
@Table(name = "tbl_state")
public class State {

  private Integer stateId;
  private String stateName;
  private Country country;

   @Id
   @Column(name="state_id")
   public String getStateId(){
      return stateId;
   }  

  @Column(name="state_name")
  public String getStateName(){
      return stateName;
  }  

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="country_id")
  public Country getCountry(){
     return country;
 }