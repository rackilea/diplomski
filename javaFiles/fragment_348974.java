class MyVisitor<T> implements Visitor{
    List<T> list = new  ArrayList<T>();

    public <T> void visit(T value){
       list.add(value);
    }
}