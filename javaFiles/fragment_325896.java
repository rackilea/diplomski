public class AnotherClass{
  MainActivity mainActivity;
  public AnotherClass(MainActivity mainActivity) {
     this.mainActivity = mainActivity;
  }

  public void changeTextViewText() {
     mainActivity.getTxt().setText("bulut");
  }
}