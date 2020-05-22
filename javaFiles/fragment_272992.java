package stackoverflow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DeleteIt {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(100000);
        arr1.add(1);
        arr1.add(100000);
        arr1.remove(1);
        if (arr1.get(0).intValue() == arr1.get(1)) {
            System.out.println("GUd");
        } else
            System.out.println("damnit");

    }

}