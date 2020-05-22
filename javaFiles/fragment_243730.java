public class Z<T extends A & Z.Z_requirements> {
    public static interface Z_requirements {
        Boolean canDoStuff();
    }

    public Z(T base) {
        base.letBaseDoSomething();
        base.canDoStuff();
    }
}