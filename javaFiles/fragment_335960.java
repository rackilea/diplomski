public class Income {
    // Column decelerations...

    private long id;
    private int tips;
    private int hours;
    private int gas;
    private double hourly;
    private double other;
    private double other2;

    public int getGas() {
        return gas;
    }

    public double getHourly() {
        return hourly;
    }

    public int getHours() {
        return hours;
    }

    public long getId() {
        return id;
    }

    public double getOther() {
        return other;
    }

    public double getOther2() {
        return other2;
    }

    public int getTips() {
        return tips;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public void setHourly(double hourly) {
        this.hourly = hourly;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public void setOther2(double other2) {
        this.other2 = other2;
    }

    public void setTips(int tips) {
        this.tips = tips;
    }
}