class CircularNumber{

    private static final int BOUND = 360;
    private int header;

    public void add(int amt){
        header = (header + amt) % BOUND;
    }

    public void deduct(int amt){
        header = (360 + header - (amt % BOUND)) % BOUND;
    }
}