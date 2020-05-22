private static <T extends Comparable<T>> void merge(List<T> lst, int low,
    int high, int mid) {

    List<T> temp = new ArrayList<T>();

    // Fill temp list with empty values
    for(int i=0; i<lst.size(); i++){
        temp.add(null);
    }

    // Set the values we are going to work on.
    for (int i = low; i <= high; i++) {
        System.out.println(lst.get(i));
        temp.set(i,lst.get(i));
    }

    ...
}