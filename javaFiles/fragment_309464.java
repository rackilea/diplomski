@Entity
@Table(name = "PUSH_SOURCE_TABLE")
@IdClass(PushEntityPK.class)
public class PushSourceEntity implements Serializable{

/**
 * 
 */
private static final long serialVersionUID = 5162782386822573902L;

public PushSourceEntity(PushEntityPK pushEntityPK){
   this.push_id = pushEntityPK.getPush_id();
   this.entity_id = pushEntityPK.getSource_name();
}

@Id
@AttributeOverrides({@AttributeOverride(name = "push_id", column =   @Column(name = "PUSH_ID"))})
private Integer push_id;

@AttributeOverrides({@AttributeOverride(name = "entity_id", column = @Column(name = "ENTITY_ID"))})
private String entity_id;