package packageB;

import packageA.Inter;

public class BetterB implements Inter {
    @Override
    public void doSomething() {
        System.out.println("BetterB did something.");
    }
}