final static int FOO_HASHCODE = 70822; // "Foo".hashCode();
final static int BAR_HASHCODE = 66547; // "Bar".hashCode();

public static void main(String[] args) {
    String s = "Bar";
    switch (s.hashCode()) {
    case FOO_HASHCODE:
        if (s.equals("Foo"))
            System.out.println("Foo match");
        break;
    case BAR_HASHCODE:
        if (s.equals("Bar"))
            System.out.println("Bar match");
        break;
    }
}