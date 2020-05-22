import java.util.HashMap;
import java.util.Map;

public class StockDataBase {

    Map<Integer, Double> values = new HashMap<Integer, Double>();

    public void setStockValue(int i, double nextDouble) {
        values.put(i, nextDouble);

    }

    public Double getStockValue(int z) {
        return values.get(z);
    }

}