public class UnwindedHotel {

    private String name;
    private int pricePerNight;
    private Address address;
    private Review reviews;
}

UnwindOperation unwindOperation = Aggregation.unwind("reviews");
Aggregation aggregation = Aggregation.newAggregation(unwindOperation);
AggregationResults<UnwindedHotel> results=mongoOperations.aggregate(aggregation,"hotel", UnwindedHotel.class);