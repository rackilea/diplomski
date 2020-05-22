public void profile(String host, int port, List<InputData> inputDataSet) {
  Map<InputData, String> pathMap = new HashMap<InputData, String>(); //If you want to save the location of each file

  //Init profiling data collection
  com.yourkit.api.Controller controller = new Controller(host, port);
  controller.startCPUSampling(/*with your settings*/);
  controller.startAllocationRecording(/*With your settings*/);
  //controller.startXXX with whatever data you want to collect

  for (InputData input: inputDataSet) {
    //Run your test
    runTest(inputData);

    //Save profiling data
    String path = controller.captureSnapshot(/*With or without memory dump*/);
    pathMap.put(input, path);

    //Clear yourkit profiling data
    controller.clearAllocationData();
    controller.clearCPUData();
    //controller.clearXXX with whatever data you are collecting
  }
}