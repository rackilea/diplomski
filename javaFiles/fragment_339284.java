@XmlRootElement(name= "Entity1")
public class Entity {
    private String field1;
    private String field2;
    private Entity2 entity2;
    private Entity3s entity3s;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @XmlElement(name = "Entity2")
    public Entity2 getEntity2() {
        return entity2;
    }

    public void setEntity2(Entity2 entity2) {
        this.entity2 = entity2;
    }

    @XmlElement(name = "Entity3s")
    public Entity3s getEntity3s() {
        return entity3s;
    }

    public void setEntity3s(Entity3s entity3s) {
        this.entity3s = entity3s;
    }

}