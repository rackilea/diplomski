package tests;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list0 = new ArrayList<Integer>();
        list0.add(1);
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        List<Integer>[] listArray = new ArrayList[2];
        listArray[0] = list0;
        listArray[1] = list1;
        int maxListSize = 2;

        List newList = new ArrayList();
        for (int i = 0; i < maxListSize; i++) {
            List innerList = new ArrayList<Integer>();
            for (int j = 0; j < listArray.length; j++) {
                if (listArray[j].size() > i) {
                    innerList.add(listArray[j].get(i));
                } else {
                    innerList.add(null);
                }
            }
            newList.add(innerList);
        }
        System.out.println(newList);

    }
}