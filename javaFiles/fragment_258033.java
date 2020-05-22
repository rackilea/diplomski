import java.util.*;

public class Main {
public static void main(String[] args){
    List<String> data = Arrays.asList("/foo", "/bar", "/foo/admin", "/foo/cust", "/bar/erp", "/bar/erp/call", "/foo/cust/profile");

    // order by path
    Collections.sort(data, new Comparator<String>(){
        @Override public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    });

    for (String s : data){
        int length = s.split("/").length - 1; // -1 means.. without empty string
        for (int i=0; i< length; i++){
            System.out.print("-- ");
        }
        System.out.println(s);
    }
}   
}