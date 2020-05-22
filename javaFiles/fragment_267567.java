import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        List<List<String>> baseLists = new ArrayList<>();
        baseLists.add(Arrays.asList("a01","a02"));
        baseLists.add(Arrays.asList("a11","a12"));
        baseLists.add(Arrays.asList("a21","a22","a23"));
        baseLists.add(Arrays.asList("a3"));
        System.out.println("Base lists: " + baseLists);
        List<List<String>> combinations = new ArrayList<>();
        // iterative solution
        baseLists.forEach(list -> {
                List<List<String>> newCombinations = new ArrayList();
                list.forEach(string -> {
                    List<List<String>> currentCombinations = new ArrayList();
                    // deep copy combinations
                    combinations.forEach(inlist -> currentCombinations.add(new ArrayList(inlist)));
                    if(currentCombinations.isEmpty()) {
                        currentCombinations.add(new ArrayList());
                    }
                    currentCombinations.forEach(inlist -> inlist.add(string));
                    newCombinations.addAll(currentCombinations);
                });
                combinations.clear();
                newCombinations.forEach(l -> combinations.add(l));
        });
        System.out.println("Combination lists: " + combinations);
    }
}