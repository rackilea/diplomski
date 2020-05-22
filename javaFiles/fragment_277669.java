@Override
public void execute(Tuple tuple, BasicOutputCollector collector) {
    try {
        DataBean bean = (DataBean)tuple.getValue(0);
        // do your bolt processing with the bean
    } catch (Exception e) {
        LOG.error("WordCountBolt error", e);
        collector.reportError(e);
    }       
}