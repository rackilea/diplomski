public class MyPolicy {
private LicenseResponse mLastResponse;

public MyPolicy(Activity activity) {
    mLastResponse = LicenseResponse.RETRY;
}

public void processServerResponse(LicenseResponse response) {
    mLastResponse = response;
}

public boolean allowAccess() { 
    return (LicenseResponse.LICENSED.equals(mLastResponse));
}