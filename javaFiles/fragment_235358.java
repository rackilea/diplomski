import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

public static List<Integer> prepareDb(String s) {
    List<Integer> result = new ArrayList<>();

    //fron similar
    HashMap<Integer, Integer> dbFront = new HashMap<>();
    HashMap<Character, Integer> lastSeenFront= new HashMap<>();
    for(int i = 0; i<s.length();i++){
        Character c = s.charAt(i);
        int distance = -1;
        if(lastSeenFront.containsKey(c)){
            distance = i - lastSeenFront.get(c);
        }
        lastSeenFront.put(c,i);
        dbFront.put(i, distance);
    }

    //backSimilar
    HashMap<Integer, Integer> dbBack = new HashMap<>();
    HashMap<Character, Integer> lastSeenBack = new HashMap<>();
    for(int i = s.length()-1; i >= 0;i--){
        Character c = s.charAt(i);
        int distance = -1;
        if(lastSeenBack.containsKey(c)){
            distance = lastSeenBack.get(c) - i;
        }
        lastSeenBack.put(c,i);
        dbBack.put(i, distance);
    }

    for(int i = 0; i<s.length();i++){
        //distance between i and the closest element
        int distance = dbFront.get(i);
        if(dbFront.get(i)==-1 || (dbBack.get(i)!=-1 && dbFront.get(i)>dbBack.get(i))){
            distance = dbBack.get(i);
        }
        result.add(distance);
    }
    return result;
}


public static List<Integer> closest(String s, List<Integer> queries) {
    List<Integer> result = new ArrayList<Integer>();

    List<Integer> db = prepareDb(s);

    //execute each query separately
    for(int i=0; i<queries.size(); i++){
        result.add(db.get(queries.get(i)));
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