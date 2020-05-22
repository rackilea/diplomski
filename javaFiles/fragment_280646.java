public class Delimiter {
  public static void main(String[] args) {
    String input = "Ab1ac2axd3nxn70-00-0-0";
    int l = input.length() - 1;
    char[] inputChars = input.toCharArray();
    StringBuilder output = new StringBuilder();

    for (int i = 0; i < l; i++) {
      char c = inputChars[i];
      output.append(c);

      if (Character.isDigit(c) && inputChars[i+1] != '-')
        output.append(' ');
    }

    output.append(inputChars[l]);
    System.out.println(output.toString());
  }
}