@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer>,
        QueryDslPredicateExecutor<Visit>{
    List<Visit> findByVisitType(String visitType);

    @Query("SELECT v FROM Visit v WHERE v.visitType='NEW'")
    List<Visit> findByVisitType();
}