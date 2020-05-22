Set<Integer> singlesSet = new HashSet<>();
singlesSet.add(1);
singlesSet.add(2);

Set<Integer> tensSet = new HashSet<>();
tensSet.add(10);
tensSet.add(20);

List<Set<Integer>> list = new ArrayList<>();
list.add(singlesSet);
list.add(tensSet);

System.out.println(list);