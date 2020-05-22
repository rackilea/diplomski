public BoxMeasureStat( Float min, Double avg, Float max, DateTime time) {
    super();

    this.min = (min);
    this.avg = (avg);
    this.max = (max);
    if (time != null) {
        this.time = time.toString(QueryResultConverter.dateFormatter);
    }
}