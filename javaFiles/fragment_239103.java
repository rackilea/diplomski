public class Query {

  public static Query select(String...fields){
    //code omitted
    return query;
  }

  public Query from(Collection<Object> collection){
    //code omitted
    return this;
  }

  public Query where(String field, Object value){
    //code omitted
    return this;
  }

}