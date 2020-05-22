@androidx.room.Dao
public interface Dao {

    @Query("SELECT monday FROM  ClassEntity WHERE id_of_a_group = :id")
    List<String> findFromMonday(String id);

    @Query("SELECT tuesday FROM  ClassEntity WHERE id_of_a_group = :id")
    List<String> findFromTuesday(String id);

    @Query("SELECT wednesday FROM  ClassEntity WHERE id_of_a_group = :id")
    List<String> findFromWednesday(String id);

    @Query("SELECT thursday FROM  ClassEntity WHERE id_of_a_group = :id")
    List<String> findFromThursday(String id);

    @Query("SELECT friday FROM  ClassEntity WHERE id_of_a_group = :id")
    List<String> findFromFriday(String id);

    @Query("SELECT id_of_a_group FROM  ClassEntity")
    List<String> getIdOfAllGroups();

    @Insert
    void insert(ClassEntity group);

    @Update
    void update(ClassEntity group);

    @Delete
    void delete(ClassEntity group);
}