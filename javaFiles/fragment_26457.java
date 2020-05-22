import  java.util.Arrays;
import  java.util.List;

public class Test  {
   public static final void main(String[] ignored)  {
     List<String> listA = Arrays.asList(new String[]{"941", "946", "940", "942"});
     List<String> listB = Arrays.asList(new String[]{"941", "942", "940", "946", "888", "466", "777"});

     System.out.println(listB.containsAll(listA));
   }
}