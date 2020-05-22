List<DataReceiver> dataReceivers = new ArrayList<DataReceiver>();
dataReceivers.add(new IF1Adapter(someIf1Implementation));
dataReceivers.add(new IF2Adapter(someIf2Implementation));
fetchData(dataReceivers);

public void fetchData(Collection<DataReceiver> receivers) {

  try {
    Data d = getSomeData();
    for (DataReceiver dr : receivers) {
      dr.dataReceived(d);
    }
  }
  catch (Exception e) {
    for (DataReceiver dr : receivers) {
      dr.onError(e.getMessage());
    } 
  }
}