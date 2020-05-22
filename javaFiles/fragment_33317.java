public class EntityType {
    Map json = null;
    public EntityType(Map json){
        this.json = json;
    }
    public <T extends EntityType> T getAs(Class<T> clazz){
        if(clazz.isInstance(this)) {
          return (T) this;
        }
        return null;
    }
}