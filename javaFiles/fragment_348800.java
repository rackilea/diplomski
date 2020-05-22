import java.util.ArrayList;
public class numbers {
   private int number1 = 50;
   private int number2 = 100;
   private List<Integer> list;

   public numbers() {
       list = new ArrayList<Integer>();
       list.add(number1);
       list.add(number2);
   }

   public List<Integer> getList() {
       return list;
   }
}