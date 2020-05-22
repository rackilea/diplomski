@Entity
@Table(name="MYENTITY")
@GenericGenerator(name="CODE_GEN", strategy = "native", parameters = 
                  { @Parameter(name="sequence", value="SEQ_NAME")})
public class MyEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="CODE_GEN")    
    @Column(name="CODE", nullable=false)
    private int code;