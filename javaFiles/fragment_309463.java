@Embeddable
public class PushEntityPK implements Serializable{

/**
 * 
 */
private static final long serialVersionUID = -5599662020926504220L;

private Integer push_id;

private String entity_id;

//Default Constructor
public PushEntityPK(){

}

public PushEntityPK(Integer push_id, String entity_id){
    this.push_id = push_id;
    this.entity_id = entity_id;
}