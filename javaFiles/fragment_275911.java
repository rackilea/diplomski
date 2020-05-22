public class Test {

    public static void main(String[] args) {        
        place(21,5);        
    }

    public static void place(int number, int sizeBucket){
        int nbBuckets = number / sizeBucket;
        int nbLeft = number % sizeBucket;
        List<Bucket> lBuckets = new ArrayList<>();
        for(int i = 0; i < nbBuckets; i++){
            lBuckets.add(new Bucket(sizeBucket, sizeBucket));
        }       
        if(nbLeft >= 2)
            lBuckets.add(new Bucket(5, nbLeft));
        else if (nbLeft == 1){
            Bucket b = lBuckets.get(lBuckets.size()-1);
            b.setSize(b.getSize()-1);
            lBuckets.add(new Bucket(sizeBucket, nbLeft+1));
        }
        System.out.println(lBuckets);
    }
}

class Bucket {
    private int capacity;
    private int size;

    public Bucket(int capacity, int size) {
        super();
        this.capacity = capacity;
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Bucket [capacity=" + capacity + ", size=" + size + "]";
    }       
}