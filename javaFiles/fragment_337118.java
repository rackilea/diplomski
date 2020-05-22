@Entity 
public class EntityB extends Model {

    @EmbeddedId
    private EntityB_PK ID;

    @ManyToOne
    @JoinColumn(name = "entityA_fk_id", insertable = false, updatable = false)
    private EntityA entityA; 

    public EntityA getEntityA() {
        return entityA;
    }

    public void setEntityA(EntityA aEntityA) {
        entityA = aEntityA;
        ID.entityA_FK_ID = aEntityA.getID();
    }

    public EntityB(String entityB_ID){
         ID = new EntityB_PK(UUID.randomUUID().toString(), entityB_ID);
    }

    public String getID() {
        return ID.entityB_ID;
    }
}