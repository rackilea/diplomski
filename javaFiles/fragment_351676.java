public interface UserRepository extends CrudRepository<User, Long>{

    User save(User user);

    @Query("SELECT t.name FROM User t where t.id = :id")
    String findNameById(@Param("id") Long id);

    @Query("UPDATE User SET NAME=:name, EMAIL=:email, ADDRESS=:address, PASSWORD=:password, NEWSLETTER=:newsletter, FRAMEWORK=:framework, SEX=:sex, NUMBER=:number, COUNTRY=:country, SKILL=:skill WHERE id=:id")
    User update (@Param("id") Long id);
}