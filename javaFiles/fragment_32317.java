import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class puzzle {

    private static LinkedHashSet<String> OPEN = new LinkedHashSet<>();
    private static HashSet<String> CLOSED = new HashSet<>();
    private static Map<String, List<String>> paths = new HashMap<>();
    public static boolean STATE = false;


    public static void main(String args[]) {

        String start = "120345678";
        String goal =  "012345678";
        String X = "";
        String temp = "";
        OPEN.add(start);
        paths.put(start, Arrays.asList(start));

        while (OPEN.isEmpty() == false && STATE == false) {
            X = OPEN.iterator().next();
            OPEN.remove(X);
            print(X);


            int pos = X.indexOf('0'); // get position of ZERO or EMPTY SPACE
            if (X.equals(goal)) {
                System.out.println("SUCCESS" +"\n" + paths.get(X));
                STATE = true;
            } else {
                // generate children
                CLOSED.add(X);

                temp = up(X, pos);
                if (!temp.equals("-1")) {
                    OPEN.add(temp);
                    updatePaths(temp, paths.get(X));
                }
                temp = down(X, pos);
                if (!temp.equals("-1")) {
                    OPEN.add(temp);
                    updatePaths(temp, paths.get(X));
                }
                    temp = left(X, pos);
                if (!temp.equals("-1")) {
                    OPEN.add(temp);
                    updatePaths(temp, paths.get(X));
                }
                temp = right(X, pos);
                if (!temp.equals("-1")) {
                    OPEN.add(temp);
                    updatePaths(temp, paths.get(X));
                }
            }
        }
    }

    static void updatePaths(String s, List<String> path){

        if(paths.containsKey(s)) return;
        List<String> newPath = new ArrayList<>(path);
        newPath.add(s);
        paths.put(s, newPath);
    }

    /*
     * MOVEMENT UP
     */
    public static String up(String s, int p) {
        String str = s;
        if (!(p < 3)) {
            char a = str.charAt(p - 3);
            String newS = str.substring(0, p) + a + str.substring(p + 1);
            str = newS.substring(0, p - 3) + '0' + newS.substring(p - 2);
        }
        // Eliminates child of X if its on OPEN or CLOSED
        if (!OPEN.contains(str) && CLOSED.contains(str) == false)
            return str;
        else
            return "-1";
    }

    /*
     * MOVEMENT DOWN
     */
    public static String down(String s, int p) {
        String str = s;
        if (!(p > 5)) {
            char a = str.charAt(p + 3);
            String newS = str.substring(0, p) + a + str.substring(p + 1);
            str = newS.substring(0, p + 3) + '0' + newS.substring(p + 4);
        }

        // Eliminates child of X if its on OPEN or CLOSED
        if (!OPEN.contains(str) && CLOSED.contains(str) == false)
            return str;
        else
            return "-1";
    }

    /*
     * MOVEMENT LEFT
     */
    public static String left(String s, int p) {
        String str = s;
        if (p != 0 && p != 3 && p != 7) {
            char a = str.charAt(p - 1);
            String newS = str.substring(0, p) + a + str.substring(p + 1);
            str = newS.substring(0, p - 1) + '0' + newS.substring(p);
        }
        // Eliminates child of X if its on OPEN or CLOSED
        if (!OPEN.contains(str) && CLOSED.contains(str) == false)
            return str;
        else
            return "-1";
    }

    /*
     * MOVEMENT RIGHT
     */
    public static String right(String s, int p) {
        String str = s;
        if (p != 2 && p != 5 && p != 8) {
            char a = str.charAt(p + 1);
            String newS = str.substring(0, p) + a + str.substring(p + 1);
            str = newS.substring(0, p + 1) + '0' + newS.substring(p + 2);
        }
        // Eliminates child of X if its on OPEN or CLOSED
        if (!OPEN.contains(str) && CLOSED.contains(str) == false)
            return str;
        else
            return "-1";
    }

    public static void print(String s) {
       System.out.println(s.substring(0, 3));
       System.out.println(s.substring(3, 6));
       System.out.println(s.substring(6, 9));
       System.out.println();
    }
}