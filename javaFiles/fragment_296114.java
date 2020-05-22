public class ConcurrentFixedSizeLinkedDeque<T> extends ConcurrentLinkedDeque<T> {

    private int sizeLimit = Integer.MAX_VALUE;

    public ConcurrentFixedSizeLinkedDeque() {
    }

    public ConcurrentFixedSizeLinkedDeque(Collection<? extends T> c) {
        super(c);
    }

    public ConcurrentFixedSizeLinkedDeque(int sizeLimit) {
        if(sizeLimit<0) sizeLimit=0;
        this.sizeLimit = sizeLimit;
    }

    public ConcurrentFixedSizeLinkedDeque(Collection<? extends T> c, int sizeLimit) {
        super(c);
        if(sizeLimit<0) sizeLimit=0;
        this.sizeLimit = sizeLimit;
    }

    public int getSizeLimit() {
        return sizeLimit;
    }

    public void setSizeLimit(int sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    @Override
    public void addFirst(T e){
        while(size()>=this.sizeLimit){
            pollLast();
        }
        super.addFirst(e);
    }

    @Override
    public void addLast(T e){
        while(size()>=this.sizeLimit){
            pollFirst();
        }
        super.addLast(e);
    }
}