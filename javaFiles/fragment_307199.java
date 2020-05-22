import java.text.SimpleDateFormat;
import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
    System.out.println("dd-mm-yyyy");
    Scanner scanner = new Scanner(System.in);
    String date = scanner.nextLine();
    Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(date);  
    System.out.println(date1);
  }
}