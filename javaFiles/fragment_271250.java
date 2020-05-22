interface CrudDao<T> {
   Serializable create(T t);
   T read(Serializable id);
   void update(T t);
   void delete(T t);
}