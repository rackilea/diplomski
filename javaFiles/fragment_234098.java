interface CrudMapper<T> {
   T getById(int id);
   T getByName(String name);
   void create(T);
   void update(T);
}