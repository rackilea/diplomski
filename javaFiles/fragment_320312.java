public int create(Job job) {
    Assert.notNull(job,"Job must not be null.");
    Assert.notNull(job.getSite(),"Site must not be null.");


    MapSqlParameterSource params = params("intSiteId",job.getSite().getId())
            .addValue("dtmStart", job.getStartDate() == null ? null : dateTimeString(job.getStartDate()))
            .addValue("dtmEnd", job.getEndDate() == null ? null : dateTimeString(job.getEndDate()))
            .addValue("intManualFl",job.isManual())
            .addValue("insertDate",dateTimeString(DateTime.now(DateTimeZone.UTC)));

    getTemplate().execute(getSql("create"), params, new PreparedStatementCallback<Boolean>(){
        @Override  
        public Boolean doInPreparedStatement(PreparedStatement ps)  
                throws SQLException, DataAccessException {   

            return 0;   
        }  
        });
   return (int)params.getValue("intSiteId");
}