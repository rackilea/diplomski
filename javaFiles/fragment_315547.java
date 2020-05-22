public class Itens implements Serializable {
    private static final long serialVersionUID = 1L;
    private String item;
    private int id;
    public Itens() {
    }
    public Itens(int id, String item) {
        this.id = id;
        this.item = item;
    }
}