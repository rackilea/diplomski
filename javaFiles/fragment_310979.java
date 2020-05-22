public class MyFoo {
    public <T extends MyFoo> T foo(){
        System.out.println("foo");
        return (T) this;
    }

    static class MyBar extends MyFoo{
        public <T extends MyBar> T bar(){
            System.out.println("bar");
            return (T) this;
        }
    }

    public static void main(String[] args) {
        final MyFoo foo = new MyFoo().foo();
        final MyBar bar1 = new MyBar().foo();
        final MyBar bar2 = new MyBar().bar();
    }

}