import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CartesianPrint {

    public static void main(String[] args) {
        Map<Integer,List<Integer>> groupMap = new LinkedHashMap<Integer,List<Integer>>();

        groupMap.put(1,Arrays.asList(new Integer[]{100,101,102}));
        groupMap.put(2,Arrays.asList(new Integer[]{200,201}));
        groupMap.put(3,Arrays.asList(new Integer[]{300}));

        List<List<Integer>> values = new ArrayList<List<Integer>>(groupMap.values());
        int[] printList = new int[values.size()];
        print(values,printList,values.size()-1);        
    }

    static void print(List<List<Integer>> values, int[] printList, int level){
        for (Integer value: values.get(level)) {
            printList[level] = value;
            if(level == 0){
                 System.out.println(Arrays.toString(printList));
            }else{
                 print(values,printList,level-1);
            }
        }       
    }

}