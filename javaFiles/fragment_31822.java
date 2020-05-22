@Override
public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
    outputFieldsDeclarer.declareStream("streamA", new Fields("A"));
    outputFieldsDeclarer.declareStream("streamB", new Fields("B"));
}


@Override
public void nextTuple() {
    outputCollector.emit("streamA", new Values("A"));
    outputCollector.emit("streamB", new Values("B"));
}