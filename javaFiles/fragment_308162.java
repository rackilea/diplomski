package com.example;

class DurableTriggersDriverDelegate extends StdJDBCDelegate {

    public DurableTriggersDriverDelegate(Logger logger, String tablePrefix, String schedName, String instanceId, ClassLoadHelper classLoadHelper) {
        super(logger, tablePrefix, schedName, instanceId, classLoadHelper);
    }

    public DurableTriggersDriverDelegate(Logger logger, String tablePrefix, String schedName, String instanceId, ClassLoadHelper classLoadHelper, Boolean useProperties) {
        super(logger, tablePrefix, schedName, instanceId, classLoadHelper, useProperties);
    }

    @Override
    public int deleteTrigger(Connection conn, TriggerKey triggerKey) throws SQLException {
        this.logger.debug("deleteTrigger(" + conn + ") skipped");
        return 1;
    }
}