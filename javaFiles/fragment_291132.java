List<Integer> linkedList = new LinkedList<Integer>();
List<Integer> arrayList = new ArrayList<Integer>();

for (List<?> list : Arrays.asList(linkedList, arrayList)) {
  System.out.println(list.getClass());
}