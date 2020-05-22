import java.util.*;

public class Test {

      public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("12880  20090506054200001");
        list.add("12880  20090506054200002");
        list.add("12880  20090513070200003");
        list.add("12880  20090513070200004");
        list.add("12880  20090520202600005");
        list.add("12880  20090520202600006");
        list.add("12880  20090520232900010");
        list.add("12880  20090520232900011");
        list.add("12880  20090520232900007");
        list.add("12880  20090520232900008");
        list.add("12880  20090520232900009");

        Collections.sort(list);

        for (String x : list) {
          System.out.println(x);
        }
      }
    }