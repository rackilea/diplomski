public class Example {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Foo.Bar bar = foo.getBar(); //note, cannot call new Foo.Bar(); as Bar is dependent on Foo
        for (int i = 0; i < 50; i++){
            System.out.println(bar.get());
        }
    }
}
class Foo {
    int val;
    Bar b;

    public Foo(){
        b = new Bar();
    }
    public Bar getBar(){
        return b;
    }
    public class Bar{
        public Bar(){
            val++;
        }
        public int get(){
            return val++;
        }
    }
}