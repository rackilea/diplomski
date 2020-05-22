public interface SurveyRepository extends CrudRepository<Survey, Long> {
    @Query("SELECT " +
           "    new com.path.to.SurveyAnswerStatistics(v.answer, COUNT(v)) " +
           "FROM " +
           "    Survey v " +
           "GROUP BY " +
           "    v.answer")
    List<SurveyAnswerStatistics> findSurveyCount();
}