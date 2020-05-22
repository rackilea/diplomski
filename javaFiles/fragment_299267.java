import java.util.List;
import java.util.ArrayList;

class Test {
    public static void main(String[] args) {
        int part1;
        List<Integer> myList = new ArrayList<>(); 

        int[] list = {1,2,3,4,5,6};
        for (int i : list) {
            part1 = i - average(list);
            myList.add(part1);
        }
    }
}