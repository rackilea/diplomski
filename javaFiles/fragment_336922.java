import java.util.Set;
import java.util.TreeSet;


public class SetTest {

Set<Integer> parameters = new TreeSet<Integer>();

  public static void main(String[] args) {
      SetTest st = new SetTest();
      Set<Integer> param = st.getParameters();
      param.add(1);
      param.add(2);
      param.add(3);

      for (Integer myVal : param) {
        System.out.println(myVal);
      }
   }

   public Set<Integer> getParameters() {
      return this.parameters;
   }
}