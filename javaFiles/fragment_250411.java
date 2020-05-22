public class TestWorker extends SwingWorker<Integer, String> {

  @Override
  protected Integer doInBackground() throws Exception {
    //This is where you execute the long running
    //code
    controller.startTest(index, idUser);
    publish("Finish");
  }

  @Override
  protected void process(List<String> chunks) {
    //Called when the task has finished executing.
    //This is where you can update your GUI when
    //the task is complete or when you want to
    //notify the user of a change.
  }
}