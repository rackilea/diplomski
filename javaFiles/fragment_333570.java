public interface NewsArticleRepository extends PagingAndSortingRepository<NewsArticle, Long> {

    @Query("SELECT n FROM NewsArticle n WHERE n NOT IN "
            + "(SELECT ur.article FROM UserReadNewsArticle ur JOIN ur.account a WHERE a.id = :readAccountId)")
    Collection<NewsArticle> findByUserReadNewsArticlesReadAccountIdNotIn(@Param("readAccountId") Long readAccountId);

}