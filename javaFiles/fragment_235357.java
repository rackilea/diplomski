import java.util.ArrayList;
import java.util.List;

public class Main {

public static List<Integer> closest(String s, List<Integer> queries) {
    List<Integer> result = new ArrayList<Integer>();
    //execute each query separately
    for(int i=0; i<queries.size(); i++){
        char target = s.charAt(queries.get(i));
        int index = queries.get(i);
        int length = s.length();

        int currentStep = 1;
        boolean founded = false;
        //search for the closest character
        while(index-currentStep>=0 || index+currentStep<length){
            if(index-currentStep>=0 && s.charAt(index-currentStep)==target){
                result.add(index-currentStep);
                founded = true;
                break;
            }else if(index+currentStep<length && s.charAt(index+currentStep)==target){
                result.add(index+currentStep);
                founded = true;
                break;
            }
            currentStep++;
        }
        if(!founded){
            //we couldn't find the element
            result.add(-1);
        }
    }
    return result;
}

public static void main(String[] args) {
    String s = "babab";
    List<Integer> queries = new ArrayList<Integer>();
    queries.add(2);

    List<Integer> result = closest(s,queries);
    for(Integer res: result){
        System.out.println(res);
    }
}

}