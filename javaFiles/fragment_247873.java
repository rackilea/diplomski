class MyObject{

    private long delta;
    private long theta;
    private long signal_1;
    private long signal_2;
    private long signal_3;
    private long signal_4;
    private long signal_5;
    private long signal_6;
    private double value_1;
    private double value_2;
    private int death;
    public long getDelta() {
        return delta;
    }
    public void setDelta(long delta) {
        this.delta = delta;
    }
    public long getTheta() {
        return theta;
    }
    public void setTheta(long theta) {
        this.theta = theta;
    }
    public long getSignal_1() {
        return signal_1;
    }
    public void setSignal_1(long signal_1) {
        this.signal_1 = signal_1;
    }
    public long getSignal_2() {
        return signal_2;
    }
    public void setSignal_2(long signal_2) {
        this.signal_2 = signal_2;
    }
    public long getSignal_3() {
        return signal_3;
    }
    public void setSignal_3(long signal_3) {
        this.signal_3 = signal_3;
    }
    public long getSignal_4() {
        return signal_4;
    }
    public void setSignal_4(long signal_4) {
        this.signal_4 = signal_4;
    }
    public long getSignal_5() {
        return signal_5;
    }
    public void setSignal_5(long signal_5) {
        this.signal_5 = signal_5;
    }
    public long getSignal_6() {
        return signal_6;
    }
    public void setSignal_6(long signal_6) {
        this.signal_6 = signal_6;
    }
    public double getValue_1() {
        return value_1;
    }
    public void setValue_1(double value_1) {
        this.value_1 = value_1;
    }
    public double getValue_2() {
        return value_2;
    }
    public void setValue_2(double value_2) {
        this.value_2 = value_2;
    }
    public int getDeath() {
        return death;
    }
    public void setDeath(int death) {
        this.death = death;
    }

    @Override
    public String toString() {
        return this.delta+","+this.theta+","+this.signal_1+","+this.signal_2+","+this.signal_3+","+this.signal_4+","+this.signal_5+","+this.signal_6+","+this.value_1+","+this.value_2+","+this.death;
    }

}