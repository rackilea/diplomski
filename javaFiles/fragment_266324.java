public class A {
    private B b = new B();

    public class B {
        public void fun() {

        }
        public A getEnclosing(){
            return A.this;
        }
    }

    public static void main(String[] args){
        A a = new A();
        System.out.println(a == a.b.getEnclosing());
    }
}