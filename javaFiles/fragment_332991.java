public static List<String> foo(List<?> list) {
    List<String> bad = (List<String>) list;

    @SuppressWarnings("unchecked")
    List<String> good = (List<String>) list;
    return good;
}