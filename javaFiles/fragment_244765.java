import java.lang.reflect.Field;

public class Test {

    public static void main(String args[]) {

    Solitaire gameClass = new Solitaire();
    Class gclass = gameClass.getClass();
    Field[] fields = gclass.getFields();

    for (int i = 0; i < fields.length; i++) {
        System.out.println("field: " + fields[i]);
        }
    }
}

class Solitaire {

    public Solitaire a;
    protected String b;
    public String c;

    public Solitaire() {
    }
}