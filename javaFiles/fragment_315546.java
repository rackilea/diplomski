public class SecondArray implements Serializable {
    private static final long serialVersionUID = 1L;
    private Itens[] subGroup;
    private int id;
    public SecondArray() {
    }
    public SecondArray(int id, Itens[] subGroup) {
        this.id = id;
        this.subGroup = subGroup;
    }
}