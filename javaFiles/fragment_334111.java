// Logging and re-throwing, but probably not recommended
public MultipleFileTransfer(final String uploadUrl) throws MalformedURLException {
// -------------------------------------------------^
    dataOutputStream = null;
    fileInputStream = null;
    httpURLConnection = null;

    try {
        url = new URL(uploadUrl);
    } catch (MalformedURLException e) {
        Log.wtf(TAG, e.getMessage());
        throw e;                       // <== Rethrowing
    }
}