public interface SurveyRepository extends CrudRepository<Survey, Long> {
    @Query(nativeQuery = true, value =
           "SELECT " +
           "    v.answer AS answer, COUNT(v) AS cnt " +
           "FROM " +
           "    Survey v " +
           "GROUP BY " +
           "    v.answer")
    List<SurveyAnswerStatistics> findSurveyCount();
}