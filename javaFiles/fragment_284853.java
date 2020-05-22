Supplier<List<Integer>> supplier = () -> { 
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(5);
        a.add(8);
        return a;
    };

    Object[] objArr = Stream.generate(supplier).limit(3).toArray();
    for (Object o : objArr) {
        ArrayList<Integer> arrList = (ArrayList<Integer>) o; // This is not safe to do, compiler can't know this is safe.
        System.out.println(arrList.get(0)); 
    }