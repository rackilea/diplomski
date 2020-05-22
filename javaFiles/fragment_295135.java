class MutableIntegerTester implements Runnable {

    private int num;
    private MutableInteger mutableInteger;

    public MutableIntegerTester(int num, MutableInteger mutableInteger) {
        this.num = num;
        this.mutableInteger = mutableInteger;
    }

    @Override
    public void run() {

        for ( int i = 0; i < 1000; i++ ) {
            mutableInteger.set(mutableInteger.get() + num);
        }
        System.out.println(mutableInteger.get());
    }

}