public static void main(String args[])
{
    String[] input = {"a", "b", "f", "h", "e", "aa"};

    Set<String> set = new TreeSet<>();
    set.addAll(Arrays.asList(input));

    System.out.println(set);

    String[] array = set.toArray(new String[0]);
    System.out.println(array[0]);

    List<String> list = new ArrayList<>(set);
    System.out.println(list.get(0));
}