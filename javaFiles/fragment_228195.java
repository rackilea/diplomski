class EnclosingClass {
    static class StaticMemberClass { }

    public static void main(String... args) {
        EnclosingClass.StaticMemberClass nestedInstance =
            new EnclosingClass.StaticMemberClass();
    }
}