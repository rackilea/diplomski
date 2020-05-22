public abstract class GenericDataInterface<KEY extends Enum> {
    public abstract Object getData(KEY key);

    public final List<Object> getEmpDataAsList(List<KEY> fields) {
        List<Object> result = new ArrayList<Object>(fields.size());
        for (KEY field : fields) {
            result.add(getData(field));
        }
        return result;
    }
}