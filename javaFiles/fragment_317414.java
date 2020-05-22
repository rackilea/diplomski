public abstract class GenericDataInterface<KEY extends Enum> {
    public abstract Object getData(KEY key);

    public final Map<KEY, Object> getEmpDataAsList(List<KEY> fields) {
        Map<KEY, Object> result = new HashMap<KEY, Object>(fields.size());
        for (KEY field : fields) {
            result.put(field, getData(field));
        }
        return result;
    }
}