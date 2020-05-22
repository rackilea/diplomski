import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


 interface DisplayElement {
     void display();
}

 interface Observer {
     void update (Map<String,Double> priceMap);
}


 class PricesDisplay implements Observer, DisplayElement {
    private String ticker;
    private double price;
    private Subject PriceData;
    Map<String,Double> priceMap;


      PricesDisplay(Subject PriceData) {
        this.PriceData = PriceData;
    }

PricesDisplay(String ticker, Subject PriceData) {
    this.ticker = ticker;
    this.PriceData = PriceData;
}

public void update(Map<String,Double> priceMap) {
    this.priceMap = priceMap;
    display();
}

public void display() {
     for (Map.Entry<String, Double> entry : priceMap.entrySet()) {
         System.out.printf("\nPortfolio #%s, " + "%s = " + "%.2f, ",
         ticker, entry.getKey(), entry.getValue());
         }
}
}



interface Subject{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
    void measurementsChanged();
    void setPrices(Map<String,Double> priceMap);
}


 class PriceData implements Subject {
    private ArrayList observers;
    PriceData priceData;
    private Map<String,Double> priceMap = new HashMap<String,Double>();

     PriceData() {
        observers = new ArrayList();
    }

public void registerObserver(Observer o) {
    observers.add(o);
}

public void removeObserver(Observer o) {
    int i = observers.indexOf(o);
    if (i >= 0) {
        observers.remove(i);
    }
}

public void notifyObservers() {
    for (int i = 0; i < observers.size(); i++) {
        Observer observer = (Observer)observers.get(i);
        observer.update(priceMap);
    }
}

public void measurementsChanged() {
    notifyObservers();
}

public void setPrices(Map<String,Double> priceMap) {
    this.priceMap = priceMap;
    measurementsChanged();
}


}







 class Test {

private static Map<String,Double> priceMap = new HashMap<String,Double>();
private static PriceData priceData = new PriceData();

public static void main(String[] args) {

    // establish two portfolios as listeners for priceData.
    // for now, we assume that both portfolios contain the same
    // collection of investments.

    PricesDisplay firstPortfolio = 
        new PricesDisplay("00001", priceData);
    PricesDisplay secondPortfolio = 
            new PricesDisplay("00002", priceData);

    priceData.registerObserver(firstPortfolio);
    priceData.registerObserver(secondPortfolio);

    generateInitialPrices();
    updatePrices(.02);
    updatePrices(-.05);
    updatePrices(.06);
}

static void generateInitialPrices()
{
    priceMap.put("ASD", 42.50);
    priceMap.put("BDM", 52.50);
    priceMap.put("CAC", 22.20);
    priceMap.put("DFAS", 45.00);        
    priceData.setPrices(priceMap);
}

static void updatePrices(double changePercent)
{
    for( String key : priceMap.keySet())
    {
        double v = priceMap.get(key) * (1.0 + changePercent);
        priceMap.put(key, v);
    }
    priceData.setPrices(priceMap);
}
}