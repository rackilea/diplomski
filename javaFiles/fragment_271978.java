private List<MyEntity> datasource; // contains only ids

@Override
public List<MyEntity> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        StringBuilder queryText = new StringBuilder("select ...");
        List<MyEntity> list;

        //paginate
        if(datasource.size() > pageSize) {
            try {
                list = new ArrayList<>(datasource.subList(first, first + pageSize));
            }
            catch(IndexOutOfBoundsException e) {
                list = new ArrayList<>(datasource.subList(first, first + (datasource.size() % pageSize)));
            }
        }
        else {
            list = new ArrayList<>(datasource);
        }

        boolean setComa = false;
        for (MyEntity a: list) {
            if (setComa) {
                queryText.append(","+a.getId());
            } else {
                queryText.append(a.getId());
                setComa = true;
            }
        }
        queryText.append(")");
        Query q = em.createQuery(queryText.toString());
        list = q.getResultList();
        return list.subList(0, list.size());
}