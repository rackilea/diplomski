public static void main(String[] argv) {
    System.out.println(dummy("foo"));
}
static <T extends Serializable&CharSequence> int dummy(T value) {
    return Optional.ofNullable(value).map(CharSequence::length).orElse(0);
}