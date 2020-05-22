List<String> list1 = new ArrayList<String>();
list1.add("1");
list1.add("2");
List<String> list2 = new ArrayList<String>();
list2.add("3");
list2.add("4");
list2.add("5");
TempContainer container1 = new TempContainer();
container1.setItems(list1);
TempContainer container2 = new TempContainer();
container2.setItems(list2);
List<TempContainer> containers = new ArrayList<TempContainer>(2);
containers.add(container1);
containers.add(container2);
// Get combinations 
List<List<T>> combinations = getCombination(0, containers);