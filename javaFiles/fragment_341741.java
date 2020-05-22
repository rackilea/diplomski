private final List<Double> temps = Collections
        .synchronizedList(new ArrayList<Double>());
private double currentAverage = 0d;

public void calculateRoomAvgTemp(TempStruct tempSensorData) {
    synchronized (this.temps) {
        this.temps.add(tempSensorData.temp);
        this.currentAverage = 0d;

        for (Double temp : this.temps) {
            this.currentAverage += temp;       
        }

        this.currentAverage /= this.temps.size();
    }
}