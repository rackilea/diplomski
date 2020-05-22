/**
 * 
 */
package hu.flux.salesforce;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;

import hu.flux.exceptions.ExceptionToolkit;
import hu.flux.input.PromptUser;

import com.sforce.soap.enterprise.InvalidIdFault;
import com.sforce.soap.enterprise.LoginResult;
import com.sforce.soap.enterprise.SessionHeader;
import com.sforce.soap.enterprise.SforceService;
import com.sforce.soap.enterprise.Soap;
import com.sun.xml.bind.api.JAXBRIContext;
import com.sun.xml.ws.api.message.Headers;
import com.sun.xml.ws.developer.WSBindingProvider;

/**
 * @author Brian Kessler
 *
 */
public class LoginToolkit {

    private Soap binding = null;
    private LoginResult loginResult = null;;

    public void setBinding(Soap binding) { this.binding = binding; }
    public Soap getBinding() { return binding; }

    public void setLoginResult(LoginResult loginResult) { this.loginResult = loginResult; }
    public LoginResult getLoginResult() { return loginResult; }

    /**
     * 
     */
    public LoginToolkit() { doLogin(); }

    private boolean doLogin()
    {   
        //String userName = getUserInput("Enter user name: ").trim();
        //String password = getUserInput("Enter password: ").trim();
        String userName = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        String password = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        binding = bindEnterpriseWSDL();

        System.out.println("LOGGING IN NOW....");
        try { loginResult = binding.login ( userName, password ); }
        catch (InvalidIdFault invalidIdFault) { return loginExceptionCaught("invalid id fault", invalidIdFault); }
        catch (com.sforce.soap.enterprise.LoginFault loginFault) { return loginExceptionCaught("login fault", loginFault); }
        catch (com.sforce.soap.enterprise.UnexpectedErrorFault unexpectedErrorFault) { return loginExceptionCaught("unexpected error fault", unexpectedErrorFault); }

        // Check if the password has expired
        return (loginResult.isPasswordExpired()) ? passwordExpired() : bindSession();
    }

    private Soap bindEnterpriseWSDL()
    {
        try 
        {
            URL wsdlLocation = this.getClass().getClassLoader().getResource("META-INF/enterprise.wsdl");
            if (wsdlLocation == null) 
            {
                WebServiceException webServiceException = new WebServiceException("enterprise.wsdl not found!");
                ExceptionToolkit.display ("Web Service Exception could not find enterprise.wsdl.", webServiceException);
                throw new WebServiceException(webServiceException);
            }
            else { System.out.println ("\n\n\nenterprise.wsdl WAS found!\n\n\n");}

            QName qName = new QName("urn:enterprise.soap.sforce.com", "SforceService");
            SforceService sforceService = new SforceService(wsdlLocation, qName);
            Soap soap = sforceService.getSoap();
            return soap; 
        } 
        catch (WebServiceException webServiceException) 
        {
            ExceptionToolkit.display ("Web Service Exception creating salesface port.", webServiceException);
            throw new WebServiceException(webServiceException);
        }
    }


    private WSBindingProvider enableGzip(BindingProvider bindingProvider) 
    {
        //Enable GZip compression
        Map<String, List<String>> httpHeaders = new HashMap<String, List<String>>();
        httpHeaders.put("Content-Encoding", Collections.singletonList("gzip"));
        httpHeaders.put("Accept-Encoding", Collections.singletonList("gzip"));
        Map<String, Object> reqContext = bindingProvider.getRequestContext();
        reqContext.put(MessageContext.HTTP_REQUEST_HEADERS, httpHeaders);
        return (WSBindingProvider) bindingProvider;
    }

    private boolean passwordExpired() 
    {
        System.out.println("An error has occured.  Your password has expired.");
        return false;
    }   

    private boolean bindSession() 
    {
        //binding._setProperty(Soap BindingStub.ENDPOINT_ADDRESS_PROPERTY, loginResult.getServerUrl());
        WSBindingProvider bindingProvider = ((WSBindingProvider) binding);
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, loginResult.getServerUrl());
        bindingProvider = enableGzip (bindingProvider);

        // Create a new session header object and add the session id from the login return object
        SessionHeader sessionHeader = new SessionHeader();
        sessionHeader.setSessionId(loginResult.getSessionId());
        bindingProvider = setJAXBContext (bindingProvider, sessionHeader);


        reportLoginSuccess();

        return true; // return true to indicate that we are logged in,  pointed at the right url and have our security token in place.
    }   

    private WSBindingProvider setJAXBContext (WSBindingProvider bindingProvider, SessionHeader sessionHeader) 
    {
        JAXBContext jc;
        try { jc = JAXBContext.newInstance("com.sforce.soap.enterprise"); } 
        catch (JAXBException jaxbException) 
        {
            ExceptionToolkit.display ("Error creating JAXBContext instance.", jaxbException);
            throw new WebServiceException(jaxbException);
        }

        bindingProvider.setOutboundHeaders(Headers.create((JAXBRIContext) jc, sessionHeader));
        return bindingProvider;
    }

    private void reportLoginSuccess() 
    {
        System.out.println("Login was successfull.");
        System.out.print("The returned session id is: ");
        System.out.println(getLoginResult().getSessionId());
        System.out.print("Your logged in user id is: ");
        System.out.println(getLoginResult().getUserId() + " \n\n");
    }

    private boolean loginExceptionCaught(String label, Exception exception) 
    { 
        ExceptionToolkit.display ("A " + label + " has occured.", exception);
        return false;
    } 

    public boolean checkLogin() 
    {
        // check to see if we are already logged in
        if (this.getLoginResult() == null) 
        {
            System.out.println("Run the login sample before the others.\n");
            PromptUser.getUserInput("Hit enter to continue: ");
            System.out.println("\n");
            return false;
        }
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {}

}