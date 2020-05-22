public class test3 {
public static void main(String[] args) {
    Owner owner = new Owner();
    owner.getThing().method(); //Like how you execute your test
    RealThing thing = new RealThing();
    thing.method(); //Similar to your mock.
}

private static class Owner {
    private BaseThing thing = new RealThing();

    public BaseThing getThing() {
        return thing;
    }
}

private static class BaseThing {
    public static void method() {
        System.out.println("Basething!");
    }
}

private static class RealThing extends BaseThing {
    public static void method() {
        System.out.println("Realthing!");
    }
}
}