static void getResponse(String input, int level) {
    Stream.iterate(input, str -> {
        int pos = str.lastIndexOf('.');
        return pos == -1 ? "" : str.substring(0, pos);
    }).limit(level+1).forEach(System.out::println);
}