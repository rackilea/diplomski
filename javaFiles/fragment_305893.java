import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map;

public class HowHungry {

    public String howHungry(Integer hunger) {
        SortedMap<Integer, String> HungerLevels = new TreeMap<>();
        HungerLevels.put(0, "Peckish");
        HungerLevels.put(50, "Very Hungry");
        HungerLevels.put(80, "Starving");

        String howHungry = null;
        for (Map.Entry<Integer,String> me : HungerLevels.entrySet() ) {
            if (hunger > me.getKey()) {
                howHungry = me.getValue();
            } else {
                break;
            }
        }
        return howHungry;
    }

    public static final void main(String[] args) {
        HowHungry hh = new HowHungry();
        System.out.println(hh.howHungry(Integer.valueOf(args[0])));
    }
}