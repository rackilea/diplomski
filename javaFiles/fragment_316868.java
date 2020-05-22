public static <T> boolean areEqualIgnoringOrder(List<T> list1, List<T> list2, Comparator<? super T> comparator) {

    // if not the same size, lists are not equal
    if (list1.size() != list2.size()) {
        return false;
    }

    // create sorted copies to avoid modifying the original lists
    List<T> copy1 = new ArrayList<>(list1);
    List<T> copy2 = new ArrayList<>(list2);

    Collections.sort(copy1, comparator);
    Collections.sort(copy2, comparator);

    // iterate through the elements and compare them one by one using
    // the provided comparator.
    Iterator<T> it1 = copy1.iterator();
    Iterator<T> it2 = copy2.iterator();
    while (it1.hasNext()) {
        T t1 = it1.next();
        T t2 = it2.next();
        if (comparator.compare(t1, t2) != 0) {
            // as soon as a difference is found, stop looping
            return false;
        }
    }
    return true;
}