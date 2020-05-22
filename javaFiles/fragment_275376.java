public class test {
  public static void main(String[] argz) { 
    for(String s : argz) {
     System.out.println("agg=" + s + "|");
    }

    System.out.println("prop=" +  System.getProperty("prop") + "|");
  }
}