@Stateless
@WebService()
public class AccountWS {

    @WebMethod()
    public CreateAccountResponse createAccount(@WebParam(name = "request") CreateAccountRequest request) {
        return null;
    }
}