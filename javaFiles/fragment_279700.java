public class Test<T> {
private Map<Integer, T> getValuesMap(int indexBegin, int indexEnd, List<T> values) {
        Map<Integer, T> map = new LinkedHashMap<>();

        if (indexBegin <= indexEnd) {
            for (int i = indexBegin; i <= indexEnd; i++) {
                map.put(i, values.get(i));
            }
        } else {
            for (int i = indexBegin; i >= indexEnd; i--) {
                map.put(i, values.get(i));
            }
        }

        return map;
    }

}