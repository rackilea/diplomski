import java.util.*;
import java.lang.*;
import java.io.*;


class TEST
{
public static void main (String[] args) throws java.lang.Exception  {
    List<Integer> list1 = Arrays.asList(1,2,3,4,5);
    List<Integer> list2 = Arrays.asList(2,3);

    for (int i=0; i<list1.size()-list2.size(); ++i) {
        if (list1.subList(i, i+list2.size()).equals(list2)) {
            System.out.println("found: "+i);
            return;
        }
    }

    System.out.println("not found");
}
}