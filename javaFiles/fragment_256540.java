class MyList<T>{
    private ArrayList<T> list;

    public MyList(){
        list = new ArrayList<>();
        ...
    }
    public void add(T t){
        list.add(t) 
        //do other things you want to do when items are added 
    }
    public T remove(T t){
        list.remove(t);
        //do other things you want to do when items are removed
    }
}