import java.util.*;

public class permutations {

        public static void main(String args[]) {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter String: ");
            String chars = s.next();
            List<String> myList = new ArrayList<String>();
            findPerms(myList, "", chars);

            Collections.sort(myList);

            for(int i=0; i<myList.size(); i++) {
               System.out.print(myList.get(i) + " ");
            }

        }

        public static void findPerms(List<String> permsList, String mystr, String chars) {

            if (chars.length() <= 1)
                permsList.add(mystr + chars);    
            else
            for (int i = 0; i < chars.length(); i++) {
                String newString = chars.substring(0, i) + chars.substring(i + 1);
                findPerms(permsList, mystr + chars.charAt(i), newString);
            }

       }
}