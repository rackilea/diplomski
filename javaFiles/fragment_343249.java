public class ItemBean implements Serializable  {
    String name;
    int id;

    public ItemBean(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name;   
    }

}