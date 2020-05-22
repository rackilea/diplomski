JavaReceiverInputDStream<Status> inputStream = TwitterUtils.createStream(jssc, getAuth());
JavaDStream<String> batchedInput = rawInput.window(new Duration(windowInterval), new Duration(slideInterval));
processStreamData(batchedInput);

private void processStreamData(JavaDStream<String> _input) {
    JavaDStream<String> input = _input.window(new Duration(windowInterval), new Duration(slideInterval));
}