package de.scrum_master.app;

import java.io.Serializable;

public class Application {
    public static class MyNonSerializable {}

    public static class MySerializable implements Serializable {
        private static final long serialVersionUID = 1L;
    }

    private static MyNonSerializable one() {
        return new MyNonSerializable();
    }

    static MySerializable two(int i, String string) {
        return new MySerializable();

    }

    static String three(int i, String string, MyNonSerializable myNonSerializable) {
        return "foo";
    }

    static MyNonSerializable four(int i, String string, MySerializable mySerializable) {
        return new MyNonSerializable();
    }

    static void five(MyNonSerializable myNonSerializable) {
    }

    static int six(MySerializable mySerializable) {
        return 11;
    }

    public static void main(String[] args) {
        one();
        two(11, "foo");
        three(11, "foo", new MyNonSerializable());
        four(11, "foo", new MySerializable());
        five(new MyNonSerializable());
        six(new MySerializable());
    }
}