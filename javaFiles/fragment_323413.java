public class HeaderCreator {
    private String authorization = "OAuth ";
    private String oAuthSignature;
    private String oAuthNonce;
    private String oAuthTimestamp;
    private String oAuthConsumerSecret;
    private String oAuthTokenSecret;

    public String getAuthorization() {
        return authorization;
    }

    public String getoAuthSignature() {
        return oAuthSignature;
    }

    public String getoAuthNonce() {
        return oAuthNonce;
    }

    public String getoAuthTimestamp() {
        return oAuthTimestamp;
    }

    public HeaderCreator(){}

    public HeaderCreator(String oAuthConsumerSecret){
        this.oAuthConsumerSecret = oAuthConsumerSecret;
    }

    public HeaderCreator(String oAuthConsumerSecret, String oAuthTokenSecret){
        this(oAuthConsumerSecret);
        this.oAuthTokenSecret = oAuthTokenSecret;
    }

    public String getTwitterServerTime() throws IOException, ParseException {
        HttpsURLConnection con = (HttpsURLConnection)
                new URL("https://api.twitter.com/oauth/request_token").openConnection();
        con.setRequestMethod("HEAD");
        con.getResponseCode();
        String twitterDate= con.getHeaderField("Date");
        DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        Date date = formatter.parse(twitterDate);
        return String.valueOf(date.getTime() / 1000L);
    }

    public String generatedSignature(String url, String method, List<NameValuePair> allParams,
                                     boolean withToken) throws SignatureException {
        oAuthNonce = String.valueOf(System.currentTimeMillis());
        allParams.add(new BasicNameValuePair("oauth_nonce", oAuthNonce));
        try {
            oAuthTimestamp = getTwitterServerTime();
            allParams.add(new BasicNameValuePair("oauth_timestamp", oAuthTimestamp));
        }catch (Exception ex){
            //TODO: Log!!
        }

        Collections.sort(allParams, new NvpComparator());
        StringBuffer params = new StringBuffer();
        for(int i=0;i<allParams.size();i++)
        {
            NameValuePair nvp = allParams.get(i);
            if (i>0) {
                params.append("&");
            }
            params.append(nvp.getName() + "=" + OAuth.percentEncode(nvp.getValue()));
        }
        String signatureBaseStringTemplate = "%s&%s&%s";
        String signatureBaseString =  String.format(signatureBaseStringTemplate,
                OAuth.percentEncode(method),
                OAuth.percentEncode(url),
                OAuth.percentEncode(params.toString()));
        String compositeKey = OAuth.percentEncode(oAuthConsumerSecret)+"&";
        if(withToken) compositeKey+=OAuth.percentEncode(oAuthTokenSecret);
        oAuthSignature =  Signature.calculateRFC2104HMAC(signatureBaseString, compositeKey);

        return oAuthSignature;
    }

    public String generatedAuthorization(List<NameValuePair> allParams){
        authorization = "OAuth ";
        Collections.sort(allParams, new NvpComparator());
        for(NameValuePair nvm : allParams){
            authorization+=nvm.getName()+"="+OAuth.percentEncode(nvm.getValue())+", ";
        }
        authorization=authorization.substring(0,authorization.length()-2);
        return authorization;
    }

}