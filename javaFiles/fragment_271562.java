abstract class Box<E extends Shape> {

    abstract protected List<E> getList();

    abstract protected void setList(List<E> list);

    protected static <T extends Shape> List<T> getCommon(Box<T> box) {
        List<T> aux = new ArrayList<T>();
        for (T s : box.getList()) {
            aux.add((T) s.clone());
        }
        return aux;
    }

    protected static <T extends Shape> void setCommon(Box<T> box, List<T> newList) {
        // do something on newList here if needed as common functionality
        box.setList(new ArrayList<T>(newList));
    }
}
class BoxA extends Box<Square> {
    private static List<Square> list;

    @Override
    protected List<Square> getList() {
        return list;
    }

    @Override
    protected void setList(List<Square> list) {
        this.list = list;
    }

    public static List<Square> get() {
        return getCommon(new BoxA());
    }

    public static void set(List<Square> newList) {
        setCommon(new BoxA(), newList);
    }
}