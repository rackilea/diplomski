private static class MilliDTSC extends DynamicTimeSeriesCollection {

    public MilliDTSC(int nSeries, int nMoments, RegularTimePeriod timeSample) {
        super(nSeries, nMoments, timeSample);
        if (timeSample instanceof Millisecond) {
            this.pointsInTime = new Millisecond[nMoments];
        }
    }
}