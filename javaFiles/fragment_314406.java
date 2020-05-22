public class extenderTask extends Task {

private List<String> listString;

@Override
protected List<String> call() throws Exception {
    this.list = functThatTakeLotOfTime();
    return this.listString;
  }
}