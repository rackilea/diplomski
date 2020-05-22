public class Foo implements Serializable {

    private final double[] timeSum;
    private final int[] timeCnt;
    private final double[] travelTimes;
    private final String linkId;
    private final transient TravelTimeDataArray ttDA;


    public Foo(TravelTimeDataArray ttDA) {
        this.ttDA = ttDA;
        this.timeSum = ttDA.getTimeSum();
        this.timeCnt = ttDA.getTimeCnt();
        this.travelTimes = ttDA.getTravelTimes();
        this.linkId = ttDA.getLink().getId();
    }

    // Methods
}