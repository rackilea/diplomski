public class MyHttpUtility
{
    public HttpGet createHttpGet( String mAuthToken, String mCreditMobileNumber, mBusinessId )
    {
        HttpGet httpGet = new HttpGet(SystemConstants.CUSTOMER_SUMMARY_URL
            + "mobile=" + mCreditMobileNumber + "&businessid="
            + mBusinessId);
        httpGet.addHeader( "Authenticate", mAuthToken );
        return httpGet;
    }       
}