public class MyClass {

  private int clicksCount = 0;

  private View.OnClickListener listener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      clicksCount += 1;
    }
  }
}