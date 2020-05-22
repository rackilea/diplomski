private static void quicksort(List<Integer> place) {
    if (place.size() <= 1)
        return;

    int median=place.size()/2;
    int pivot=place.get(median);
    place.remove(median);

    List<Integer> place2 = new ArrayList<>();
    List<Integer> place3 = new ArrayList<>();

    Iterator<Integer> it = place.iterator();
    while (it.hasNext()) {
        int i = it.next();
        if (i < pivot) {
            place2.add(i);
        } else {
            place3.add(i);
        }
        it.remove();
    }

    quicksort(place2);
    quicksort(place3);

    for (Integer i : place2) {
        place.add(i);
    }
    place.add(pivot);
    for (Integer i : place3) {
        place.add(i);
    }
}