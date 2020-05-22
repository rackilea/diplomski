import java.util.ArrayList;
import java.util.List;

public class ScenarioResultsFactory {

    public static List<ScenarioResults> createBeanCollection() {
        List<ScenarioResults> list = new ArrayList<ScenarioResults>();       
        list.add(new ScenarioResults("1", "test", "load", 10, 5));
        //add as many as you want       
        return list;
    }

}