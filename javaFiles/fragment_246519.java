import java.util.ArrayList;

public class TypedArrayList<E> extends ArrayList<E> implements TypedList {
    private Class ListType;
    public TypedArrayList(Class c) {
        DefaultConstructor(c);
    };
    public TypedArrayList(Class c, java.util.Collection<? extends E> collection) {
        super(collection);
        DefaultConstructor(c);
    }
    private void DefaultConstructor(Class c) { ListType=c; }
    @Override public Class GetListClass() {
        return ListType;
    }
}