import java.lang.reflect.Field;


public class Values {

    public static boolean enabled = false;

    public static void main(String[] args) throws Exception {           
        Values v = new Values();

        Field field = v.getClass().getField("enabled");

        field.set( v, true );

        System.out.println( field.get(v) );         
    }

}