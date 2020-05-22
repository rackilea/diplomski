@Component
public class MediaRepositoryImpl implements CustomQuery {
    @PersistenceContext
    EntityManager manager;

    public List<Integer>myCustomQuery(int id){
        Query q = manager.createNativeQuery(SQL_QUERY_GOES_HERE);
        List<Integer> ids = new ArratList<Integer>();

        @SuppressWarnings("unchecked")
        List<Integer> result  = q.getResultList();
        for(Integer o : result){
            //process the results and add them to the list
        }
        return list;
    }
}