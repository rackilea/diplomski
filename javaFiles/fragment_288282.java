import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SavingsApp {

    public Map<Integer, Integer> arraysToMap(int[] years, int[] money) {
        Map<Integer, Integer> newMap = new HashMap<Integer, Integer>();
        if (years == null || money == null || years.length != money.length) {
            throw new IllegalArgumentException();
        }
        for (int i=0; i< years.length; i++ ) {
            newMap.put(years[i], money[i]);
        }

        return newMap;
    }

    public Map<Integer, Integer> calculateSavings(Map<Integer, Integer> earningsMap, Map<Integer, Integer>expensesMap) {
        Map<Integer, Integer> savingsMap = new TreeMap<Integer, Integer>();
        savingsMap.putAll(earningsMap);

        for (Entry<Integer, Integer> expensePerYear : expensesMap.entrySet()) {
            Integer year = expensePerYear.getKey();
            Integer expense = expensePerYear.getValue();

            Integer earning = savingsMap.get(year);
            if (earning == null) {
                earning = 0;
            }
            savingsMap.put(year, earning-expense);
        }
        return savingsMap;
    }


    public static void main(String[] args) {
        int[] earningYear = {2012,2013,2014};
        int[] earningAmount = {100,150,120};
        int[] expenseYear = {2012,2014};
        int[] expenseAmount = {50,30};

        SavingsApp app = new SavingsApp();

        // convert arrays to maps
        Map<Integer, Integer> earningsMap = app.arraysToMap(earningYear, earningAmount);
        Map<Integer, Integer> expensesMap = app.arraysToMap(expenseYear, expenseAmount);

        // compute savings per year
        Map<Integer, Integer> savingsMap = app.calculateSavings(earningsMap, expensesMap);

        // convert result map to array
        List<Integer> savingsList = new ArrayList<Integer>(savingsMap.values());
        Integer[] savingsArray = new Integer[savingsList.size()];
        savingsList.toArray(savingsArray);
    }
}