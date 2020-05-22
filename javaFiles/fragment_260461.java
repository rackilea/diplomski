public static void main(String[] args)
{
    final List<List<Integer>> lists = new ArrayList<List<Integer>>();

    final List<Integer> list0 = new ArrayList<Integer>();
    list0.add(0);
    list0.add(1);
    list0.add(2); 
    list0.add(4);
    lists.add(list0);
    lists.add(list0);
    lists.add(list0);

    permute(lists, (permutation -> System.out.println(permutation)));
}