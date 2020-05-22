public void execute(Tuple tuple) {
  String sentence = tuple.getString(0);
  for(String word: sentence.split(" ")) {
    _collector.emit(tuple, new Values(word));  //emits multiple tuples
  }
  _collector.ack(tuple);
}