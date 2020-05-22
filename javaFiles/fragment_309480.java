public class ClassOne {

}

public class ClassTwo extends ClassOne {

}

public class Test {

    public void someMethod(ClassOne one) {

        System.out.println(one.getClass().getName());
    }

}

public class Main {

    public static void main(String[] args) {

        ClassTwo t = new ClassTwo();
        Test tst = new Test();
        tst.someMethod(t);
    }

}