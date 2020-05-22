public class FirstArray implements Serializable {
    private static final long serialVersionUID = 1L;
    private SecondArray[] group;
    private int id;
    public FirstArray() {
    }
    public FirstArray(int id, SecondArray[] group) {
        this.id = id;
        this.group = group;
    }
}