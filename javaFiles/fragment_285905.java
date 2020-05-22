ImmutableList.Builder<String> builder1 = new ImmutableList.Builder<>();
builder1.add("Test1"); // builder1
List<String> list1 = builder1.build();


ImmutableList.Builder<String> builder2 = new ImmutableList.Builder<>();
builder1.add("Test1"); // again builder1
List<String> list2 = builder2.build();

System.out.println(list1.equals(list2));
//--> false


List<String> defaultList1 = new LinkedList<>();
defaultList1.add("Test1");

List<String> defaultList2 = new LinkedList<>();
defaultList2.add("Test1");

System.out.println(defaultList1.equals(defaultList2));
// --> true