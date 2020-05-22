public class Update implements ReferenceCounted {
    @Override
    public final Update retain() {
        return new Update(id, updateType, makeRetainedBuffers());
    }  

    private Map makeRetainedBuffers() {
       Map newMap = new HashMap();
       for (Entry entry : keyValueMapping) {
           newMap.put(entry.key, entry.value.duplicate().retain())
       }
       return newMap;
    }
}