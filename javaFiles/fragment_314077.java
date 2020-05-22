public class Field <T> {
    private Class <? extends T> clazz;

    public <TT extends T> Field (Class <TT> clazz) {
        this.clazz = clazz;
    }

    public static void main (String [] args) {
        new Field <Iterable <?>> (List.class);
    }
}