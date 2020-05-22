public class Ally implements Character {
    public void doAction() {
        System.out.println("Defend");
    }
}

public class Enemy implements Character {
    public void doAction() {
        System.out.println("Attack");
    }
}