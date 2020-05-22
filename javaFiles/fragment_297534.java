public class SuperBoss {
    int x = 10;
}

public class Boss extends SuperBoss {
    int x = 2;

    public static void main ( String[] args ) {
        Boss b = new Boss();
        System.out.println(((SuperBoss)b).x);
    }
}