public interface CtThhlastikaPressThreatsRepository extends CrudRepository<CtThhlastikaPressThreats, Long>, org.springframework.data.repository.Repository<CtThhlastikaPressThreats, Long> {

    Optional<CtThhlastikaPressThreats> findById(Long id);

    CtThhlastikaPressThreats findCtThhlastikaPressThreatsById(Long id);

    @Query(nativeQuery = true, value = "SELECT DISTINCT ct.act_code FROM ct_thhlastika_press_threats ct ORDER BY act_code ASC")
    ArrayList<String> findDistinctByActCodeOrderByActCode();
}