public interface WineRepository extends PagingAndSortingRepository<Wine,Long> {
  @Query("select * from wine where ...")
  List<Wine> findAllWinesWhereKeywordLikes(Pageable pageable);

  default List<Wine> findTop10WinesWhereKeywordLikes() {
    return findAllWinesWhereKeywordLikes(new PageRequest(0,10));
  }

}