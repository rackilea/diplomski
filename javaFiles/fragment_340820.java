import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * This interceptor verify the method name  and log the details
 * */
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.ResourceMethod;
//import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

@Provider
@ServerInterceptor
public class PreSecurityInterceptor implements PreProcessInterceptor {
    @Context HttpServletRequest req;

    @Override
    public ServerResponse preProcess(HttpRequest request, ResourceMethod method)
            throws Failure, WebApplicationException {

        System.out.println("********************************************* pre process *****************************");

        System.out.println(new Date() + " Method : " + method.getMethod().getName() + " being called from  "
                + req.getRemoteHost()+":"+req.getLocalPort()+": Remote Port "+req.getRemotePort());

         if ( "defaultMethod".equalsIgnoreCase(method.getMethod().getName())) {
            return null; // normal flow continues
        } else {
            System.out.println(new Date() + " Method : " + method.getMethod().getName() + " Precondition failed ");
            return (ServerResponse) Response
                    .status(Response.Status.PRECONDITION_FAILED).entity("invalid method details provided !!").build();
        }  
    }
}