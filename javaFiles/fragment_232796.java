public static void main(String args[])
{
    String[] input = {"a", "b", "f", "h", "e", "aa"};

    int i = 0;
    Map<Integer, String> map = new TreeMap<>();
    for(String s: input) {
        map.put(i++, s);
    }

    System.out.println(map);
}