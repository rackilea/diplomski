public void execute(Tuple tuple) {
    try {
        // process tuple here
        collector.emit("your_stream",tuple,new Values(value));
    } catch(Execption e) {
        // don't emit
    } finally {
        collector.ack(tuple);
    }
}