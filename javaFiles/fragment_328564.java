@Entity
@Table(name="player")
public class Player {


   @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   @JoinColumn(name = "team_id", nullable = false, insertable = false, updatable = false)
   Team team;

}