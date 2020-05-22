public class MyObject {
  private String text;
  private int[11] numbers = new int[11];

  public String getText() { return text; }
  public void setText(String text) { this.text = text; }
  public int getNumber(int index) { return numbers[index]; }
  public void setNumber(int index, int value) { numbers[index] = value; }
}