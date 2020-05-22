import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class Main {

public static void main(String[] args) {
    String test[] = {"(2, [(3, 4), (5, 6), (5, 6)])",
            "(7, [(3, 4), (5, 6)])",
            "(10, [(3, 4)])"
    };

    // clean string
    for (int i = 0; i < test.length; i++){
        test[i] = test[i].replace("(", "")
                .replace("[", "")
                .replace(")", "")
                .replace("]", "")
                .replace(" ", "");
    }

    List<Pair> pairList = new ArrayList();

    for (String s : test){
        String[] tmpStrArr = s.split(",");
        List<Pair> tmpLst = new ArrayList<Pair>();

        int index = Integer.parseInt(tmpStrArr[0]);
        for (int i = 1; i < tmpStrArr.length; i += 2){
            tmpLst.add(new Pair(index, new Pair(tmpStrArr[i], tmpStrArr[i + 1])));
        }

        pairList.addAll(tmpLst);
    }

    // just here for break point
    System.out.println();
}