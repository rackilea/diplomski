@SuppressWarnings("unchecked")
    ArrayList<Integer> l = (ArrayList<Integer>)getRawArrayList();
    l.add(1);
    l.add(2);
    ArrayList<String> l2 = l.stream()
                            .map(Object::toString)
                            .collect(Collectors.toCollection(ArrayList::new));