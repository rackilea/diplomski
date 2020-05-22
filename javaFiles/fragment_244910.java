import java.util.ArrayList;
public class test {
    private static ArrayList<Integer> stringToArrayList(String s){ 
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (String t : s.split(",")) {
            ans.add(Integer.parseInt(t));
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> t1 = stringToArrayList("1,2,6");
        ArrayList<Integer> t2 = stringToArrayList("1,3,5");

        ArrayList<Integer> intersection = new ArrayList<Integer>(t1);
        intersection.retainAll(t2);
        System.out.println  ( "Charstic sets Intersection  :::  "+intersection );

    }
};