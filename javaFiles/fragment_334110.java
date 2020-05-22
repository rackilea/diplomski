public MultipleFileTransfer(final String uploadUrl) throws MalformedURLException {
// -------------------------------------------------^
    dataOutputStream = null;
    fileInputStream = null;
    httpURLConnection = null;

    url = new URL(uploadUrl);
}