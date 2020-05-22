public class TestClass implements Serializable {

    /**
     * Serializable id
     */
    private static final long serialVersionUID = 5574815106264956078L;

    private int id;
    private String name;

    TestClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "TestClass [id=" + id + ", name=" + name + "]";
    }
}