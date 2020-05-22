public String buildActionUrl(String instanceUrl, String action, String rkey) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("action", action));
    params.add(new BasicNameValuePair("rkey", rkey));

    String paramString = URLEncodedUtils.format(params, "UTF-8");
    try {
        return URLEncoder.encode(instanceUrl + paramString, "UTF-8");
    } catch (UnsupportedEncodingException e) {
        logger.error("", e);
        return ".";     // return the action to be defaulted to the originating page
    }
}