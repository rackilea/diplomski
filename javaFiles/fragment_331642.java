public static void explode(final String string, final char delimiter){
    final List<String> list = new LinkedList<>();
    int index, prev = 0;
    while((index = string.indexOf(delimiter, prev)) > -1){
        list.add(string.substring(prev, index));
        prev = index+1;
    }
    list.add(string.substring(prev));
    System.out.println(list.size());
    list.forEach(System.out::println);
}