List<List<Integer>> sums = new ArrayList<List<Integer>>();

sums.add(Arrays.asList(1, 3, 6));
sums.add(Arrays.asList(4, 3, 8, 1));
sums.add(Arrays.asList(1, 3));

Element max = getNthMax(sums, 0);
Element secondMax = getNthMax(sums, 1);

System.out.println(max.getIndicies()); // [2, 3]
System.out.println(secondMax.getIndicies()); // [1, 3]