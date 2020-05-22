@Entity
@Table(name="traineeStatus")
public class TraineeStatus {


   @OneToMany(mappedBy = "traineestatus")
   private List<Trainees> orderItems;

   ...

   // GETTERS and SETTERS

}