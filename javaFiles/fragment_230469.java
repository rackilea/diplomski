public String buildActionUrl(String baseUrl, Map<String, String> parameters, String encoding) throws UnsupportedEncodingException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    for (String param : parameters.keySet() ) {
        params.add(new BasicNameValuePair(param, parameters.get(param)));
    }
    return URLEncoder.encode(baseUrl + URLEncodedUtils.format(params, encoding), encoding);
}