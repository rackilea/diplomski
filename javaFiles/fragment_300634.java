public class Deque {
    private long[] queArray;
    private int maxSize;
    private int nItems;
    private int left;
    private int right;

    private boolean isEmpty() { return nItems == 0; }
    private boolean isFull() { return nItems == maxSize; }

    public Deque(int maxSize) {
        this.maxSize = maxSize;
        queArray = new long [maxSize];
        nItems = 0;
        left = 0;
        right = maxSize - 1;
    }

    public void insertLeft(long j) {
        if (isFull()) 
            throw new RuntimeException("It is full");

        if (left == 0)         
            left = maxSize;
        queArray[--left] = j;         
        nItems++;                     
    }

    public void insertRight(long i) {
        if (isFull())
            throw new RuntimeException("It is full");

        if (right == maxSize - 1)      
            right = -1;
        queArray[++right] = i;         
        nItems++;                     
    }

    public long removeLeft() {  
        if (isEmpty())
            throw new RuntimeException("It is empty");

        long temp = queArray[left];
        left++;
        if (left == maxSize - 1)
            left = -1;
        nItems--;
        return temp;
    }

    public long removeRight() {
        if (isEmpty())
            throw new RuntimeException("It is empty");

        long temp = queArray[right];
        right--;
        if (right < 0)
            right = maxSize - 1;
        nItems--;   
        return temp;
    }

}