@Path("/foo")
public class FooResource
{
    @GET
    @Produces("text/csv")
    public List<Consumer> getConsumers()
    {
        Consumer consumer1 = new Consumer();
        consumer1.setId("1234");
        consumer1.setGender("Male");

        Consumer consumer2 = new Consumer();
        consumer2.setId("2345");
        consumer2.setGender("Male");

        List<Consumer> consumers = new ArrayList<Consumer>();
        consumers.add(consumer1);
        consumers.add(consumer2);

        return consumers;
    }
}