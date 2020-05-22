import java.util.*;

public class Main_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int m = sc.nextInt();
        for(int i = 0; i < m; i++){
            String password = sc.next();
            System.out.println(got(password));
        }
    }

    public static String got(String password) {
        HashMap<Character, Integer> checkpass = new HashMap<>();
        Character ch = null;
        Integer val = 0;
        int odd = 0, even = 0;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (checkpass.containsKey(ch) == false) {
                checkpass.put(ch, 1);
            } else {
                 val = (Integer) checkpass.get(ch);
                checkpass.put(ch, val + 1);
            }
         }
         Set<Character> hashval = checkpass.keySet();
        for (Character key : hashval) {
             val = (Integer) checkpass.get(key);
            if (val == password.length())
                return "YES";
            else if (val % 2 == 1)
                odd++;
            else
                even++;
        }
        if (odd == 1 || odd == 0)
            return "YES";
        else
            return "NO";
    }

}