List<List<Integer>> input = Arrays.asList(Arrays.asList(1,2,3,4),
                                          Arrays.asList(5,6,7),
                                          Arrays.asList(8,9,10,11,12));

Iterator<Integer>[] iters = new Iterator[input.size()];
int i = 0;
for (List<Integer> list : input)
    iters[i++] = list.iterator();

List<List<Integer>> output = new ArrayList<>();
while (true) {
    List<Integer> sublist = new ArrayList<>(iters.length);
    for (Iterator<Integer> iter : iters)
        if (iter.hasNext())
            sublist.add(iter.next());
    if (sublist.isEmpty())
        break;
    output.add(sublist);
}

System.out.println("Input:  " + input);
System.out.println("Output: " + output);