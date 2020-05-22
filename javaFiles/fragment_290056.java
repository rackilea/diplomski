class A{
    private ArrayList<Show> list;

    public A(){
        list = new ArrayList<Show>();
    }

    public void aad(Show val){
        list.add(val);
    }

    public void showList(){
        list.forEach(Show::showData);
    }
}