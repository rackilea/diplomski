public enum Stuff extends Enum<Stuff> {
    /*public static final*/ COW /* = new Stuff("COW", 0) */,
    /*public static final*/ POTATO /* = new Stuff("POTATO", 1) */,
    /*public static final*/ MOUSE /* = new Stuff("MOUSE", 2) */;
    /*synthetic*/ private static final Stuff[] $VALUES = new Stuff[]{Stuff.COW, Stuff.POTATO, Stuff.MOUSE};

    public static Stuff[] values() {
        return (Stuff[])$VALUES.clone();
    }

    public static Stuff valueOf(String name) {
        return (Stuff)Enum.valueOf(Stuff.class, name);
    }

    private Stuff(/*synthetic*/ String $enum$name, /*synthetic*/ int $enum$ordinal) {
        super($enum$name, $enum$ordinal);
    }
}