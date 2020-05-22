List<Integer> original = Arrays.asList(12,16,17,19,101);
List<Integer> selected = Arrays.asList(16,19,107,108,109);

ArrayList<Integer> add = new ArrayList<Integer>(selected);
add.removeAll(original);
System.out.println("Add: " + add);

ArrayList<Integer> remove = new ArrayList<Integer>(original);
remove.removeAll(selected);
System.out.println("Remove: " + remove);