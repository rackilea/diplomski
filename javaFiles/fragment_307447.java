import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class StringPlusNull {

    public static void main(String[] args) {
        List<String> countryList 
            = Arrays.asList("U.S.", "U.K.", "China", "Japan", "Korea");
        SortedSet<String> countrySet
            = new TreeSet<>(countryList);

        String toElement = "Japan";
        SortedSet<String> countryHeadSet 
            = countrySet.headSet(toElement);
        System.out.format("There are %d countries in the "
                + "(half-open) headset [, %s): %s%n"
                , countryHeadSet.size(), toElement, countryHeadSet);

        toElement = "Japan\0";
        countryHeadSet 
            = countrySet.headSet(toElement);
        System.out.format("There are %d countries in the "
                + "(half-open) headset [, %s): %s%n"
                , countryHeadSet.size(), toElement, countryHeadSet);
    }

}