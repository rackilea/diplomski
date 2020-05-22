public class ItemCounter<T>{

    private Map<T, Integer> counts = new HashMap<T, Integer>();

    public void addItem(T item){
        Integer numberOfOcurrences = counts.get( item );            
        numberOfOcurrences = numberOfOcurrences == null ? 0 : numberOfOcurrences+1;
        counts.put( item,  numberOfOcurrences);            
    }

    public Integer getCount( T item ){
        Integer numberOfOcurrences = counts.get( item );    
        return numberOfOcurrences == null ? 0 : numberOfOcurrences;
    }
}