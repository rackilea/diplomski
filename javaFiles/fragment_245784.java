interface PromotionServiceXrefRepository extends PagingAndSortingRepository<PromotionServiceXref, Integer> {

  @Query("…")
  @Cacheable("servicesByCustomerId")
  Set<PromotionServiceXref> findByCustomerId(int customerId);

  @Override
  @CacheEvict(value = "servicesByCustomerId", key = "#p0.customer.id")
  <S extends PromotionServiceXref> S save(S service);
}