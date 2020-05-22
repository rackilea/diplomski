import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {

            List<List<Integer>> outerList = new ArrayList<List<Integer>>();
            outerList.add(new ArrayList<Integer>(asList(11,2)));
            outerList.add(new ArrayList<Integer>(asList(2,1)));
            outerList.add(new ArrayList<Integer>(asList(11,3)));
            outerList.add(new ArrayList<Integer>(asList(6,2)));
            outerList.add(new ArrayList<Integer>(asList(7,2)));
            outerList.add(new ArrayList<Integer>(asList(9,3)));
            outerList.add(new ArrayList<Integer>(asList(3,1)));
            outerList.add(new ArrayList<Integer>(asList(5,1)));
            outerList.add(new ArrayList<Integer>(asList(10,3)));


            if(outerList.size() == 0) return;

            Collections.sort(outerList, new CustomComparator());

            System.out.println(outerList);

            List<List<Integer>> newOuterList = new ArrayList<List<Integer>>();
            int i = 0;
            int value = outerList.get(0).get(1);
            while(i < outerList.size()) {
                List<Integer> newInnerList = new ArrayList<Integer>();
                while(i < outerList.size()) {
                    if(outerList.get(i).get(1) == value) {
                        newInnerList.add(outerList.get(i).get(0));
                        i++;
                    } else {
                        value = outerList.get(i).get(1);
                        break;
                    }
                }
                newOuterList.add(newInnerList);
            }
            System.out.println(newOuterList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CustomComparator implements Comparator<List<Integer>> {
    @Override
    public int compare(List<Integer> o1, List<Integer> o2) {
        return o1.get(1).compareTo(o2.get(1));
    }
}