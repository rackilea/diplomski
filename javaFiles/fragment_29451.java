public class TestInner {
    public static void main(String args[]){
        Person p = new Testperson();
        p.eat();
    }

    public class Testperson extends Person {
        void eat() {
            System.out.println("nice fruits");
        }
    }
}