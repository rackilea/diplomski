import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestClass {

    @Test(dataProvider = "dp")
    public void testMethod(Map<Integer, List<String>> data) {
        Assert.assertTrue(data.size() == 1);
        List<String> values = data.values().iterator().next();
        System.err.println("Values = " + values);
    }


    @DataProvider(name = "dp")
    public Object[][] getData() {
        Map<Integer, List<String>> data = getTableArray();
        //Transform the Map into a 2D array such that every key/value
        //pair in the map becomes one element in the 2D array
        int size = data.size();
        Object[][] dataToUse = new Object[size][1];
        int i = 0;
        for (Map.Entry<Integer, List<String>> entry : data.entrySet()) {
            Map<Integer, List<String>> localMap = new HashMap<>();
            localMap.put(entry.getKey(), entry.getValue());
            dataToUse[i++] = new Object[]{localMap};
        }
        return dataToUse;
    }

    static Map<Integer, List<String>> getTableArray() {
        Map<Integer, List<String>> data = new HashMap<>();
        data.put(1, Arrays.asList("Sample1", "Name1", "sample1.name1@gmail.com", "(000) 111-1111"));
        data.put(2, Arrays.asList("Sample2", "Name2", "sample2.name2@gmail.com", "(000) 111-1112"));
        data.put(3, Arrays.asList("Sample3", "Name3", "sample3.name3@gmail.com", "(000) 111-1113"));
        return data;
    }
}