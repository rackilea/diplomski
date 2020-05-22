@Entity
@SequenceGenerator(
name = "seqid-gen", 
sequenceName = "RTDS_ADSINPUT_SEQ" 
initiaValue = 1, allocationSize = 1)
public class XXX {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
   private long id;

    //getter, setter
}