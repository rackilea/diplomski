public class CallRetriever {

// The customer's Account Sid
public static final String ACCOUNT_SID = "AC123";

// Your own Auth Token
public static final String AUTH_TOKEN = "456bef";

public static CallList getAllCalls(String ACCOUNT_SID,String AUTH_TOKEN) throws TwilioRestException {

    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
    Account mainAccount = client.getAccount();
    retrun mainAccount.getCalls();

  }
}