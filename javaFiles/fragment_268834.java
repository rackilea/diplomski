class EdcBatchStatusItemReader extends     org.springframework.batch.item.database.JdbcCursorItemReader implements
org.springframework.beans.factory.InitializingBean {

    protected String batchStatus;

    public void getBatchStatus(String batchStatus) {
            this.batchStatus = batchStatus;
    }

    public void afterPropertiesSet() {
        setSql("SELECT r.EDCBATCH_OPEN_DATETIME As openDate FROM rev_acq_edcbatch r WHERE r.EDCBATCH_STATUS ='" + batchStatus + "'");
    }

}