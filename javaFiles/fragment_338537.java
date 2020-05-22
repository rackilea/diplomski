public interface Type {
    public static final int BAZ = 1;
}
public class Foo extends Frame implements Type{
    public Foo() {
        System.out.println(BAZ);  
    }
}