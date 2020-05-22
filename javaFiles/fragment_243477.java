final MyCounter counter = new MyCounter();
Collections.sort(drivDataList, new Comparator<DrivData>() {
    @Override
    public int compare(DrivData o1, DrivData o2) {
        long l1 = o1.getTime();
        long l2 = o1.getTime();
        if (l1 > l2) {
            return 1;
        } else if (l1 < l2) {
            return -1;
        } else {
            counter.incrementN();
            return 0;
        }
    }
});
// use counter

class MyCounter {
private int n;

public MyCounter() {
    this.n = 0;
}

public int getN() {
    return n;
}

public void incrementN() {
    this.n++;
}
}