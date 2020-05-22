public class Wrapper<T> {
    String name;
    Class<T> type;
    public Wrapper(String n, Class<T> t){
        name =n;
        type = t;
    }
    String toString(){return name};
}

//Then pass these objects to your array adapter:
Wrapper wrapper1= new Wrapper("Start System",SystemActivity.class);
...
Wrapper[] wrappers = {wrapper1,wrapper2..}
setListAdapter(new ArrayAdapter<Wrapper>(...,wrappers,..));

onListItemClick(...){
    Wrapper clicked = wrappers[position];
    Intent i = new Intent(Menu.this, clicked.type);
    startActivity(i);
}