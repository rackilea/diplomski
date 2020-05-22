String sql = jf.renderInlined(
  jf.insertInto(SURVEY)
    .set(SURVEY.ID, surveyId)
    .set(SURVEY.NAME, survey.getName())
    .set(SURVEY.IDML, val(idml, SQLDataType.CLOB))
);