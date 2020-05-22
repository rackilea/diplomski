String userPassword = "login:password";
URL url = new URL(ksGateUrl);
// URLConnection urlc =  url.openConnection();
URLConnection urlc =  new URLConnection(url);

urlc.setDoOutput(true);
urlc.setUseCaches(false);
urlc.setAllowUserInteraction(false);
urlc.setRequestProperty("Authorization", 
        "Basic " + new sun.misc.BASE64Encoder().encode (userPassword.getBytes()));

urlc.connect();