public static <T> ByString<T> byString(T[] values) {
        final Map<String,T> byToStrings = new HashMap<>(
            (int)(values.length/0.75f)+1 // Doesn't HashMap construction suck.
        );
        for (T value : values) {
            byToStrings.put(values.toString(), value);
        }
        return new ByString<T>() {
            public T find(String toString) {
                T value = byToStrings.get(toString);
                if (value == null) {
                    throw new IllegalArgumentException();
                }
                return value;
            }
        };
    }