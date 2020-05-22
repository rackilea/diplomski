import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FrequencyComparator implements Comparator<String>{

    List<String> list;

    @Override
    public int compare(String o1, String o2) {
        if (Collections.frequency(list, o1) > Collections.frequency(list, o2)){
            return -1;
        }else if (Collections.frequency(list, o1) < Collections.frequency(list, o2)){
            return 1;
        }else{
            return o1.compareTo(o2);
        }
    }

    public FrequencyComparator(List<String> list){
        this.list = list;
    }

    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("You");
        list.add("Hello");
        list.add("You");
        list.add("Apple");
        list.add("Apple");
        list.add("Hello");
        Set<String> unique = new HashSet<>(list);
        List<String> uniqueList = new ArrayList<>(unique);
        Collections.sort(uniqueList, new FrequencyComparator(list));
        System.out.println(uniqueList);
        //Take the most frequent 2 objects
        System.out.println(uniqueList.subList(uniqueList.size() - 2, uniqueList.size());
    }

}