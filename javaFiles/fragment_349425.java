// My assumption of how your ArrayListList is defined.
class ArrayListList<E> extends ArrayList<List<E>> implements ListList<E> {}

ListList<? super Integer> llOfSuperI = new ArrayListList<>();
llOfSuperI.add(new ArrayList<Integer>());  // capture fails to match Integer
llOfSuperI.add(new ArrayList<Number>());   // capture fails to match Number
llOfSuperI.add(new ArrayList<Object>());   // capture fails to match Object