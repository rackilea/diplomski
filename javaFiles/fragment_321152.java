@NameBinding
@Target({METHOD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SomeAnno {}

@SomeAnno
public class Filter implements ContainerRequestFilter {}

@SomeAnno
@Path("v2")
public class V2Resource {

    @Path("sub")
    public V2SubResource get()  {
        return new V2SubResource();
    }

    @SomeAnno
    public static class V2SubResource {
        @GET
        public String get() { return "get"; }
    }
}