import java.lang.reflect.Array
...
public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
    ArrayList<E> retList = new ArrayList<>(list.size());
    if (list.isEmpty()) return retList;
    if (list.get(0).getClass().isArray()) {
        boolean matching;
        for (int idx = 0; idx < list.size() - 1; ++idx) {
            E tempStart = list.get(idx);
            for (int k = idx + 1; k < list.size(); k++) {
                matching = true;
                E tempScan = list.get(k);
                int tempStartLen = Array.getLength(tempStart);
                for (int index = 0; index < tempStartLen; index++) {
                    if (Array.get(tempScan, index) != Array.get(tempStart, index)) {
                        matching = false;
                    }
                }
                if (matching) {
                    list.remove(tempScan);
                    k--;
                }
            }
        }
        return retList;
    } else {
        throw new IllegalArgumentException("List element type expected to be an array");
    }
}