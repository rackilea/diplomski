class MyVisitor<T> implements Visitor{
    List<T> list = new  ArrayList<T>();

    public <V> void visit(V value){
       list.add(value);
    }
}