@Entity
public class Sdr{
   @Id
   @Column(name="ID")
   private long id;

   @ManyToMany
   @JoinTable(name="cals",
          joinColumns={@JoinColumn(name="duration", referencedColumnName="duration")},
          inverseJoinColumns={@JoinColumn(name="operator_id", referencedColumnName="id")})
   private List<Operator> operators;

}