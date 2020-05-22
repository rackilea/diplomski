import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander.Iljushkin
 * Date: 23.10.13
 * Time: 11:32
 */
public class TestClass1 {


    public static void main(String[] args) {
        String[] football_club = {"Barcelona", "Real Madrid", "Chelsea", "Real Madrid", "Barcelona", "Barcelona"};
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String tempStr;
        for (int i = 0; i < football_club.length; i++)
        {
            tempStr = football_club[i];
            if(map.containsKey(tempStr))
            {
                map.put(tempStr, map.get(tempStr) + 1);
            }
            else
            {
                map.put(tempStr,1);
            }
        }

        System.out.print(map.toString());
    }
}