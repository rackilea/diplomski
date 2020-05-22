private List<T> tList;
private Iterator<T> itor;

public GenericBox()
{
        t = new ArrayList<T>();
        itor = tList.listIterator();
}
public void insert(T t)
{
        tList.add(t);
}