public class TestClass {

    String s;

    TestClass(String s) {
        this.s = s;
    }

    public static void main(String[] args) {

        String s1 = new String("a");
        String s2 = new String("a");
        System.out.println(s1 == s2);

        TestClass t1 = new TestClass("a");
        TestClass t2 = new TestClass("a"); 
        System.out.println(t1 == t2);      // here you are comparing t1 with t2, not t1.s with t2.s so you get false... 
        System.out.println(t1.s == t2.s); // t1.s and t2.s refer to the same "a", so you get true.

     TestClass t3 = new TestClass(s1);
     TestClass t4 = new TestClass(s2);
     System.out.println(t3.s == t4.s);      // false because s1 and s2 are 2 different references. 
    }

}
O/P : 
false
false
true
false