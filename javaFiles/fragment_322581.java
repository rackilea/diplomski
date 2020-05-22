public interface LimitRepository extends JpaRepository<CLimit, Long> {

  @Transactional
  @Modifying
  @Query("delete from CLimit l where l.trader.id =:#{#trader.id}")
  void deleteLimitsByTrader(@Param("trader") CTrader trader);

}