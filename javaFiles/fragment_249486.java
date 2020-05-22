public class ResultHolder {
  private String result; // Whichever result code you need to persist
  public String getResult() {return result;}
  public void setResult(String result) {this.result = result;}

  private static final ResultHolder holder = new ResultHolder();
  public static ResultHolder getInstance() {return holder;}
}