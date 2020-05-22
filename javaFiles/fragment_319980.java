package testThinkingInJava;

import testMiscellaneous.Miscellaneous2;

public class Application {
    String s = Miscellaneous2.staticMember;

    public static void main(String[] args) {
        Miscellaneous2 miscellaneous2 = new Miscellaneous2();

        String s2 = Miscellaneous2.staticMethod();

        System.out.println(s2);

        System.out.println(Miscellaneous2.staticMember);
    }
}