import java.util.ArrayList;
import java.util.List;

public class Snippet {

    public static void main(String[] args) {

        // define test data
        List<Number> subjectsResults = new ArrayList<>();
        subjectsResults.add((int) 50);
        subjectsResults.add((float) 33.333f);

        // create target list
        List<Integer> subjectsNumbers = new ArrayList<>();

        // iterate over input
        for (Number number : subjectsResults) {

            // use method "intValue", which is available for all "Number"-objects
            subjectsNumbers.add(number.intValue());
        }

        System.out.println(subjectsNumbers);
    }

}