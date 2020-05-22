package test;

public class Test {

    static {
        int i = 2;
        i = 3;
        System.out.println(i);
    }

}

package test;

public class Test {

    static {
        i = 3;
        int i = 3;
        System.out.println(i);
    }

}