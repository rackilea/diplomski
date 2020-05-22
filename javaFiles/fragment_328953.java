public static ArrayList<Integer> partitionFind(List<Integer> AList, int b, boolean lessThan) {
        ArrayList<Integer> store = new ArrayList<Integer>();
        for (int element : AList)
            if (element < b && lessThan)
                    store.add(element);
            else if (element > b && !lessThan)
                    store.add(element);
        return store;
    }