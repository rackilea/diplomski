public abstract class AbstractService<T>{

    public abstract Class<T> getClazz();

    public List<T> deserialize(final String json){
        JsonArray array = parser.parse(json).getAsJsonArray();
        final List<T> entityList = new ArrayList<V>();
        for(final JsonElement jsonElement: array){
            T entity = gson.fromJson(jsonElement, getClazz());
            entityList.add(entity);
        }
        return entityList;
    }
}