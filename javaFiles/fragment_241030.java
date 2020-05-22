static <K, V> List<Map<K, V>> castMapList(
        Object obj, Class<K> keyType, Class<V> valueType) {
    if (obj instanceof List<?>) {
        List<Map<K, V>> result = new ArrayList<>();

        for (Object element : (List<?>) obj) {
            if (element instanceof Map<?, ?>) {
                Map<K, V> map = new HashMap<>();

                for (Map.Entry<?, ?> entry : (Map<?, ?>) element) {
                    map.put(keyType.cast(entry.getKey()),
                            valueType.cast(entry.getValue());
                }

                result.add(map);
            } else {
                // do something that you want?
                // personally I would throw ClassCastExceptions
                // but you seem to be returning null
            }
        }

        return result;
    }
    return null;
}