@Embeddable
public class ProjectPK implements Serializable {
@Column(name = "SL_NO")
private Integer SlNo;
@Column(name = "PROJECT_NO")
private Long projectNo; 

//with hashCode and equals implementation