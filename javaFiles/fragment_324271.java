@Dao
public abstract UserDao {

 @Insert(onConflict = OnConflictStrategy.REPLACE)
 abstract void Insert(User... users);

 @Query("SELECT * FROM Users")
 abstract LiveData<List<User>> getRoomUsers();

 @Insert(onConflict = OnConflictStrategy.IGNORE)
 abstract void insert( List<Users> list);

 @Query("DELETE FROM Users")
 abstract void deleteAll();

 @Transaction
 void deleteAndInsert(List<Users> list){
   deleteAll();
   insert(list);
 }

}