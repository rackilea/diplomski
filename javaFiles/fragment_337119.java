@Embeddable 
public class EntityB_PK implements Serializable {

    public String entityB_ID;

    @Column(name="entityA_fk_id")
    public String entityA_FK_ID;

    public EntityB_PK(String entB_ID, String entA_FK_ID){
       entityB_ID = entB_ID;
       entityA_FK_ID = entA_FK_ID;
    } 

    @Override
    public int hashCode() {
        return entityB_ID.length() + entityA_FK_ID.length();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        EntityB_PK b = (EntityB_PK)obj;
        if(b==null)
            return false;
        if (b.entityB_ID.equals(entityB_ID) && b.entityA_FK_ID.equals(entityA_FK_ID)) {
            return true;
        }
        return false;
    }
}