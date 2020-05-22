public void data(@RequestBody DataRequestModel dataRequestModel)  {

  List<Payload> list = new ArrayList<>();
  // first object
  Payload payload1 = new Payload();
  payload1.setGuid(//set value);
  payload1.setLongValue(dataRequestModel.getData().getValue1().getVal());
  payload1.setTimestamp(dataRequestModel.getTimestamp());
  list.add(payload1);
  // second object
  Payload payload2 = new Payload();
   payload12setGuid(//set value);
  payload2.setLongValue(dataRequestModel.getData().getValue2().getVal());
  payload1.setTimestamp(dataRequestModel.getTimestamp());
  list.add(payload2);