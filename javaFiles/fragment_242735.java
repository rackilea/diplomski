public class Test {

    public void foo() {
        bar("Bar");
    }

    public void bar(String s) {
        System.out.println(s.equals("Bar"));
    }

}