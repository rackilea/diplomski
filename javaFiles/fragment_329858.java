enum Attribute { POSITIVE, NEGATIVE }
enum Content {
    C1(Attribute.POSITIVE),
    C2(Attribute.POSITIVE),
    ... // some other positive enum instances.
    Cm(Attribute.NEGATIVE),
    ... // some other negative enum instances.
    Cn(Attribute.NEGATIVE);

    private final Attribute a;

    private static class IntHolder {
        static int negativeOffset;
    }

    private Content(Attribute a) {
        this.a = a;
        if ( a == Attribute.POSITIVE) {
               IntHolder.negativeOffset ++;
        }
    }

    public static int getNegativeOffset() { return IntHolder.negativeOffset; }
}