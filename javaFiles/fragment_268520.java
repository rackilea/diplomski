@FunctionalInterface
interface Finder {
    <T> T apply(Map<T, T> map);
}

private static String fun(Finder finder) {
    // same body
}