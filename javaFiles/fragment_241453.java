import io.reactivex.Flowable;
    import io.vertx.core.json.Json;
    import org.reactivestreams.Publisher;

    import javax.ws.rs.Consumes;
    import javax.ws.rs.GET;
    import javax.ws.rs.Path;
    import javax.ws.rs.Produces;
    import javax.ws.rs.core.MediaType;
    import java.util.ArrayList;
    import java.util.Collection;

    @Path("/addresses")
    @Consumes(MediaType.APPLICATION_JSON)
    public class AddressResource {
      private Collection<Address> addresses;

      public AddressResource() {
        super();
        addresses = new ArrayList<>();
      }

      @GET
      @Produces(MediaType.SERVER_SENT_EVENTS)
      public Publisher<String> get() {
        Address address = new Address();
        address.setStreet("590 Holly Street");
        address.setCity("Townsend");
        address.setState("Ohio");
        address.setZip(6794);
        addresses.add(address);
        return Flowable.fromIterable(addresses).map(Json::encode);
      }
    }