import java.util.ArrayList;
import java.util.List;

class MyList {
    private String x;

    public MyList(String x) {
        this.x = x;
    }

    public static void main(String[] args) {
        List<MyList> ts = new ArrayList<MyList>();
        ts.add(new MyList("one"));
        ts.add(new MyList("two"));
        ts.add(new MyList("three"));

        MyList t = new MyList("one");
        System.out.println("Is t in ts? " + ts.contains(t));
    }

    @Override
    public String toString() {
        return x;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && toString().equals(obj.toString());
    }
}