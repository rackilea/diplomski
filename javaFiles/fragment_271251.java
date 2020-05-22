class SomeDao {

   @Create
   long create(SomeEntity e) { // code }

   @Read
   SomeEntity read(long id) { // code }

   @Update
   void update(SomeEntity e) { // code }

   @Delete
   void delete(SomeEntity e) { // code }
}