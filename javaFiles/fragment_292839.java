public void sendMail(String to, String subject, String msg,      Callback<MailGunResponse> cb){
String from = "test <test@address.com>";
String clientIdAndSecret = "api" + ":" + "key-*******";
String authorizationHeader = BASIC + " " +     Base64.encodeToString(clientIdAndSecret.getBytes(), Base64.NO_WRAP);
sendMailApi.authUser(authorizationHeader,from, to, subject, msg, cb);
}

public MailGun() {
RestAdapter restAdapter = getAuthAdapter();
sendMailApi = restAdapter.create(SendMailApi.class);
}

private RestAdapter getAuthAdapter(){
RestAdapter.LogLevel logLevel = RestAdapter.LogLevel.FULL;
if(DEBUG)logLevel = RestAdapter.LogLevel.FULL;
return new RestAdapter.Builder()
        .setEndpoint(ENDPOINT)
        .setConverter(new GsonConverter(new Gson()))
        .setLogLevel(logLevel)
        .build();
}