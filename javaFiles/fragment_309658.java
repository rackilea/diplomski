public static <T extends Comparable<? super T>> List<List<List<T>>> level(List<List<T>> items, int level) {
    List<List<List<T>>> result = new ArrayList<>();
    if(level == 1) {
        for(List<T> item : items) {
            result.add(Collections.singletonList(item));
        }
        return result;
    }

    for(int i = 0; i < level; i++) {
        if(i == 0) {
            for(List<T> item : items)
                result.add(Collections.singletonList(item));
            continue;
        }

        List<List<List<T>>> newResult = new ArrayList<>();
        for(List<List<T>> item : result) {
            List<List<List<T>>> combined = new ArrayList<>();
            List<T> first = item.get(0);
            for(int j = 0; j < items.size(); j++) {
                List<List<T>> current = new ArrayList<>();
                List<T> it = items.get(j);
                current.addAll(item);
                current.add(it);

                combined.add(current);
            }

            newResult.addAll(combined);
        }

        result = newResult;
    }

    clean(result);
    return result;
}