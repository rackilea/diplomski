import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Test {
    public static void main(String args[]){
        Integer idArr[] =  {1000, 1001};
        String unitArr2[] = {"1000  Yes 3   33","1001   No  No  22","1002   No  Yes 4","1003    No  No  13"};

        ArrayList<String> list = new ArrayList<String>(Arrays.asList(unitArr2));

        for(int id: idArr){
            Iterator<String> iterator = list.iterator();
            while(iterator.hasNext()){
                String unit = iterator.next();
                if(Integer.parseInt(unit.split("\t")[0]) == id){
                    iterator.remove();
                    break;
                }
            }
        }

        for(String unit: list){
            System.out.println(unit);
        }
    }
}