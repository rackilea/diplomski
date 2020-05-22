public class x {
  public static void main(String[] args) {
    try {
      FileWriter fs = new FileWriter("ahmed.txt");
      fs.write("21");

      fs.close();
      FileReader fr = new FileReader("ahmed.txt");
      //String x = Integer.toString(fr.read());
      Scanner s = new Scanner(fr);
      int x = s.nextInt();
      System.out.println(x);
      s.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}