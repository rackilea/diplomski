package foo.bar;

public class Outer{

    public enum Inner{}

    public static void main(final String[] args){
        System.out.println(Inner.class.getName());
    }

}