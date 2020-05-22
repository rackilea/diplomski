import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/form")
public class FormResource {

    @POST
    @Consumes("multipart/form-data")
    @Produces("text/plain")
    public String addIssuancesForFP(@FormDataParam("listA") List<TypeA> list1, 
                                     @FormDataParam("listB") List<TypeB> list2) {

        StringBuilder response = new StringBuilder();
        for(TypeA a: list1) {
            response.append(a.toString()).append("; ");
        }

        for (TypeB b: list2) {
            response.append(b.toString()).append("; ");
        }

        System.out.println("Service is called correctly");
        return response.toString();
    }
}