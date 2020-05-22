import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MainClass {
  public static void main(String[] args) {
    ArrayList<HashMap<String, String>> recallList = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> hashMap;
    hashMap = new HashMap<String, String>();
    hashMap.put("company", "a");
    recallList.add(hashMap);
    hashMap = new HashMap<String, String>();
    hashMap.put("company", "c");
    recallList.add(hashMap);
    hashMap = new HashMap<String, String>();
    hashMap.put("company", "b");
    recallList.add(hashMap);
    System.out.println(recallList);
    Collections.sort(recallList, new Comparator<HashMap<String, String>>() {
      @Override
      public int compare(HashMap<String, String> hashMap1, HashMap<String, String> hashMap2) {
        return hashMap1.get("company").compareTo(hashMap2.get("company"));
      }
    });
    System.out.println(recallList);
  }
}