import java.util.*;

public class Bla {                         
    public static void main(String[] args) {
        // Create list
        List<String[]> mystuff = new ArrayList<String[]>();
        mystuff.add(new String[] {"lilu", "lolo"});
        mystuff.add(new String[] {"lala"});
        mystuff.add(new String[] {"lila", "blabla", "pfirsichkuchen"});

        // Sort list
        Collections.sort(mystuff, new Comparator<String[]>() {
            public int compare(String[] x, String[] y) {
                if(x.length < y.length) {
                    return -1;
                } else if(x.length == y.length) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        // Output list
        for(String[] strs : mystuff) {
            System.out.println(Arrays.toString(strs));
        }
    }   
}