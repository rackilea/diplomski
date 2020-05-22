public class Pattern {
  private char [][] field;

  public Pattern(int size) {
    field = new char [size][size];
  }

  public void fillField() {
    int size = field.length;
    for(int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int value = i+j + 1;
        field[i][j] = value % 2 == 0 ? 'A' : ' ';
      }
    }
  }

  public String toString() {
    int size = field.length;

    StringBuilder builder = new StringBuilder(size * size);

    for(int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        builder.append(field[i][j]);
        builder.append(',');
      }
      builder.append('\n');
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    Pattern p = new Pattern(5);
    p.fillField();
    System.out.print(p);
  }
}