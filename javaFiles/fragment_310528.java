public interface UserRepository extends JpaRepository<User, Integer> {
    User findOneByNameAndAge(String name, int age); // Answer point 2

    List<User> findByName(String name); // Answer point 3

    @Modifying
    @Query("delete from User u where u.name = ?1")
    int deleteByName(String name); // Answer point 4

    @Modifying
    @Query("update User u set u.name = ?1 where u.name = ?2")
    int updateByName(String newName, String oldName); // Answer point 5
}