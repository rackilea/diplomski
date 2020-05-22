import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.ws.rs.NameBinding;

@NameBinding
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AddDescription {

}
...

@AddDescription
@Provider
public class MyDTOWriterInterceptor implements WriterInterceptor {
...

@Path("dto")
public class MyDTOResource {

    @GET
    @AddDescription
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDto() {
        return Response.ok(new MyDTO()).build();
    }
}