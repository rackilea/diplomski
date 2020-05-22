public static void main(String args[])
{
    String[] input = {"a", "b", "f", "h", "e", "aa"};

    List<String> list = new ArrayList<>(Arrays.asList(input));
    list.sort(Comparator.naturalOrder());
    System.out.println(list);
}