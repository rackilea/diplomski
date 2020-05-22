public String getUnsecureContentBase64(String url)
        throws ClientProtocolException, IOException {

            //getUnsecureContent will generate some byte[]
    byte[] result = getUnsecureContent(url);

            // use apache org.apache.commons.codec.binary.Base64
            // if you're sending back as a http request result you may have to
            // org.apache.commons.httpclient.util.URIUtil.encodeQuery
    return Base64.encodeBase64String(result);
}