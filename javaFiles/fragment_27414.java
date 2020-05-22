public interface StudentRepository extends JpaRepository<Student, Long>{

    @Override
    @Query("update Person p set p.active = false where p.id = ?1")
    @Modifying
    @Transactional
    void deactivate(Long id);
}