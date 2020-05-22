public class Ex2 {
  private int[] values;
  private int[] savedState;
  public Ex2(int [] initialValues) {
    values = initialValues;
    savedState = initialValues.clone();
  }

  public void reset(){
    values = savedState.clone();
  }
}