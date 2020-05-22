static <T> Collector<T, ?, List<T>> minList(Comparator<? super T> comp) {
    return Collector.of(ArrayList::new, (list, t) -> {
        int c;
        if (list.isEmpty() || (c = comp.compare(t, list.get(0))) == 0)
            list.add(t);
        else if (c < 0) {
            /*
             * We have found a smaller element than what we already have. Clear the list and
             * add this smallest element to it.
             */
            list.clear();
            list.add(t);
        }
    }, (list1, list2) -> {
        if (comp.compare(list1.get(0), list2.get(0)) < 0)
            return list1;
        else if (comp.compare(list1.get(0), list2.get(0)) > 0)
            return list2;
        else {
            list1.addAll(list2);
            return list1;
        }
    });
}