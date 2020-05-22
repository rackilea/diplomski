import java.util.List;
import java.util.ArrayList;
class YourClass {
    private int position;
    private String data;
    public YourClass( int position, String data ) {
        this.position = position;
        this.data = data;
    }
    public int position() {
        return position;
    }
    public String toString() {
        return String.format("{position: %d %s}", position, data);
    }
}
class Main {
    public static void main( String ... args ) {
        List<YourClass> list = new ArrayList<>();

        add( list, new YourClass(3, "object 3"));
        add( list, new YourClass(5, "object 5"));
        add( list, new YourClass(2, "object 2"));
        add( list, new YourClass(1, "object 1"));
        System.out.println(list);
    }
    public static void add( List<YourClass> list, YourClass o ) {
        for ( int i = 0 ; i < list.size(); i++ ) {
            if ( list.get(i).position() > o.position() ) {
                list.add(i, o);
                return;
            }
        }
        list.add(o);
    }
}