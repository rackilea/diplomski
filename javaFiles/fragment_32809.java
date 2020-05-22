@Transactional
@Modifying
@Query( "UPDATE Person p" +
        " SET p.age = :age " +
        " WHERE p.lastName = :lastName" )
List<Person> updateByLastName(@Param("age") int age, @Param("lastName") String lastName);