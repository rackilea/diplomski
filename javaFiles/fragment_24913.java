import static java.lang.System.*;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(12);
        list.add(19);
        list.add(442);
        list.add(3);
        list.add(1);
        list.add(9);
        out.println(list.toString());
        out.println(bubbleSort(list));
        out.println(list.toString());
    }
    public static int bubbleSort(ArrayList<Integer> num) {
        //copy the array list to new array list
        ArrayList<Integer> numtemp = new ArrayList<Integer>(num);
        int j;
        boolean flag = true;
        int temp;
        while(flag) {
            flag = false;
            for(j = 0; j < numtemp.size() - 1; j++) {
                if(numtemp.get(j) > numtemp.get(j + 1)) {
                    temp = numtemp.get(j);
                    numtemp.set(j, numtemp.get(j + 1));
                    numtemp.set(j + 1, temp);
                    flag = true;
                }
            }
        }
        return numtemp.get(0);
    }
}