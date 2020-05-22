public class DayPrices {
    private double open;        
    private double high;
    private double low;
    // more variables

    public getOpen() {
        return open;
    }

    // more getters

    public void readFile() {
        open = Double.parseDouble(open1[counter]);        
        high = Double.parseDouble(high1[counter]);
        low = Double.parseDouble(low1[counter]);
        //...
    }
}