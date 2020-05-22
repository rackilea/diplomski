public class MyKafkaSpout extends KafkaSpout {
  final String streamName;

  public MyKafkaSpout(String stream) {
    this.streamName = stream;
  }

  // other stuff omitted

  @Override
  public void declareOutputFields(OutputFieldsDeclarer declarer) {
    // compare KafkaSpout.declareOutputFields(...)
    declarer.declare(streamName, _spoutConfig.scheme.getOutputFields());
  }
}