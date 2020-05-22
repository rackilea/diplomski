public class Store {
    private List<Stock> items;

    public Store(List<Stock> items){
        this.items = items;
    }

    public List<Stock> getStock(){ 
        // get stock for this Store object. 
        return this.items;
    } 
    public void addStock(Stock stock){
        this.getStock().add(stock);
    }
}