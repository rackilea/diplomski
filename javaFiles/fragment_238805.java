public interface Query{
  public Map<String, String> execute(Map<String, String> map);
} 

@Singleton
public class QueryA implements Query{
  @Override
  public Map<String, String> execute(Map<String, String> map){
    //queryA logic.
  }
}     

public class CustomQuery implements Query{
  List<Query> queryList;

  public void CustomQuery(List<Query> queries){
    this.queryList = queries;
  }

  public void CustomQuery(Query query1, Query query2){
    this.queryList = new ArrayList();
    queryList.add(query1);
    queryList.add(query2);
  }

  @Override
  public Map<String, String> execute(Map<String, String> map){
    if(queryList == null){
         return map;
    }

    Map<String, String> eventMap = map;
    for(Query query: queryList){
        eventMap = query.execute(eventMap);
    }
    return eventMap;
  }
}