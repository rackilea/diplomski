public class Wrapper<T extends Super> {

    private List<T> list = new ArrayList<T>();

    void doStuff(){
        List<Sub> al = new ArrayList<Sub>();
        for(Sub s : al)
            list.add((T) s);
    }

}