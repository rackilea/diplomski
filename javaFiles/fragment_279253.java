List<String> list1 = new ArrayList<>();
List<Integer> list2 = new ArrayList<>();
System.out.println(list1.equals(list2)); // true

list1 = new TypedList<>(list1, String.class);
list2 = new TypedList<>(list2, Integer.class);
System.out.println(list1.equals(list2)); // false