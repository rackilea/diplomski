import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.UnmarshalException;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException>{

    @Context
    private HttpServletRequest cr;

    @Override
    public Response toResponse(BadRequestException e) {

        String reason = String.format("Reason: %s", e.toString());

        if( e.getCause() instanceof UnmarshalException )
            reason = "Request payload is invalid.";

        if( e.getCause() instanceof NoContentException )
            reason = "No payload given.";

        return Response.status(Status.BAD_REQUEST)
            .entity(String.format("%s [resource:%s, contentType:%s, method:%s]", reason, cr.getPathInfo(), cr.getContentType(), cr.getMethod() ) ).build();
    }

}