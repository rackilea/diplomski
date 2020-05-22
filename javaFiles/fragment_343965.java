class CustomTree {
    private final Map store;
    private final int length;

    public CustomTree(List<List<String>> source, int length) {
        if (length < 2)
            throw new IllegalArgumentException("Length must be greater than 2");

        this.length = length;
        this.store = new HashMap();
        for (int i = 0; i < source.size(); i++) {
            List<String> line = source.get(i);
            if (line.size() != length)
                throw new IllegalArgumentException(String.format("Line %d has wrong length", i));
        }

        for (List<String> line : source) {
            if (line.size() != length)
                throw new IllegalArgumentException("Not all lines have right length");

            accumulate(store, line);
        }
    }

    public void accumulate(Map parent, List<String> keys) {
        String key = keys.get(0);
        Object value = parent.get(key);
        if (keys.size() == 2) {
            parent.put(key, value != null
                    ? addToList((List) value, keys.get(1))
                    : addToList(new ArrayList(), keys.get(1)));
        } else {
            Map child;
            if (value != null) {
                child = (Map) value;
            } else {
                child = new HashMap();
                parent.put(key, child);
            }
            accumulate(child, keys.subList(1, keys.size()));
        }
    }

    private List addToList(List list, String key) {
        Integer intValue = Integer.valueOf(key);
        if (!list.contains(intValue))
            list.add(intValue);
        return list;
    }

    public List<Integer> get(List<String> keys) {
        if (keys.size() != (length - 1))
            throw new IllegalArgumentException("Bad keys length");
        return get(keys, store);
    }

    private List<Integer> get(List<String> keys, Map tree) {
        Object object = tree.get(keys.get(0));
        if (object == null)
            return new ArrayList<Integer>(0);

        return keys.size() == 1
                ? ((List<Integer>) object)
                : get(keys.subList(1, keys.size()), (Map) object);
    }
}