public class User2 {

    private Integer id;
    private String name;

    public User2() {
    }

    public User2(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("{id=%s,name=%s}", id, name);
    }
}