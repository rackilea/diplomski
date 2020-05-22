@SuppressWarnings("unchecked")
public List<Model> findPage(int page, String search, String searchFields, 
    String orderBy, String order, String where) 
{
    return Model.Manager.factoryFor(entityClass).fetch((page - 1) * getPageSize(),
        getPageSize(), orderBy, order, searchFields == null ? 
        new ArrayList<String>() : Arrays.asList(searchFields.split("[ ]")), 
        search, where);
}