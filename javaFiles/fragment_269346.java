public class LicenseValidator {
...
    public void handleResponse(LicenseResponse response, ResponseData rawData) {
        mPolicy.processServerResponse(response);
        if (mPolicy.allowAccess()) {
            mCallback.allow();
        } else if (response == LicenseResponse.NOT_LICENSED) {
            mCallback.dontAllow();
        }
    }