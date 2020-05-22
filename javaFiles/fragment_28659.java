package testFile;

import objectFile.ABC;

public class TestABC {

    public static void main(String[] args) {
        ABC abc1 = new ABC(1);
        ABC abc2 = new ABC(2);

        System.out.println("abc1.i is " + abc1.getI());
        System.out.println("abc2.i is " + abc2.getI());
    }
}