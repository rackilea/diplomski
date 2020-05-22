public class GenericClass{
     public <T> void storeGenericClass(Store<T> store, Class<T> clazz){
            String sql = "SELECT field1, field2 FROM MYTABLE WHERE ID = 1";
            try(org.sql2o.Connection con = sql2o.open()) {
                store.set(con.createQuery(sql).executeAndFetchFirst(clazz));
            }
        }

      public <T> void storeGenericClass(List<T> store, Class<T> clazz){
            String sql = "SELECT field1, field2 FROM " + 
              clazz.getName().toUpperCase();
            try(org.sql2o.Connection con = sql2o.open()) {
                store.addAll(con.createQuery(sql).executeAndFetch(clazz));
            }
        }

}