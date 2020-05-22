public class EntityListener {

    @PrePersist
    @PreUpdate
    public void setRecInfo(Entity entity) {
        RecInfo recInfo = new RecInfo();
        // TODO set recInfo fields
        entity.setRecInfo(recInfo);
    }

}

@Entity
@EntityListeners (value = {EntityListener.class})
public class Entity {

    private RecInfo recInfo;

    public RecInfo getRecInfo() { return recInfo };

    public void setRecInfo(RecInfo recInfo) { this.recInfo = recInfo };

}