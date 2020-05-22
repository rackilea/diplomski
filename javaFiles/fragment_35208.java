try {
    final Date lastQueryDateTime = new Date();
    QueryMode queryMode = job.getQueryModeEnum();
    String code = queryMode.getCode();
    try{
        if (code.equals("FULL") || code.equals("INCREMENTAL")) 
        {
            calculateCoverage();
        }   
    } finally {
        job.setLastQueryDate(lastQueryDateTime);
        job.save(job);
    }
    return true;
} catch (Exception e) {
    LOG.error("Error while calculating the coverage for products.", e);
    return false;
}