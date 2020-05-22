import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/hello")
@Api
public class Endpoint {

    @GET
    @ApiOperation("Get message")
    @Produces(MediaType.TEXT_PLAIN)
    public String message() {
        return "Hello";
    }

}