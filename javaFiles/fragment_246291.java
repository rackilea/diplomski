public abstract class Box<T extends Number> {
    private List<T> list;

     public Box(){
        list = new ArrayList<T>();
    }

    public T get(int i){
        if(i <list.size())
            return list.get(i);
        else
            return getDefault();
    }

    protected abstract T getDefault();
}