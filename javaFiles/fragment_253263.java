import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

public class ServiceHandler extends ActionSupport {
    public String execute(){

        String response = "";

        // Get request parameters
        // Make a request to a remote server via an http connection
        // Transform result via XSL

        //uses dom4j for XML/XSL stuff
        //this should never be empty
        response = resultDoc.asXML();

        HttpServletResponse httpResponse = ServletActionContext.getResponse();
        try{
            httpResponse.getOutputStream().print(response);
        }
        catch(IOException e){
            return "failure";
        }

        return null;
    }
}