log.info("CounterpartyDAO.getRmCounterpartiesForReview [" + rm + "]");
    PreparedStatement pStmt = statementFactory.getSelectByReviewDateAndRmStmt();

    String query = pStmt.getQueryString();
    Date maxDate = dateUtils.addDays( dateUtils.getToday(), 3);
    String maxDateString = dateUtils.getAnyDate(maxDate, "dd-MM-yyyy");
    query = String.format( query, maxDateString, rm );

    ResultSet rs = cassandraDatasource.getSession().execute( query );