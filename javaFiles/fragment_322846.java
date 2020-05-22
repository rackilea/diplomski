// I guess you're using org.apache.commons.httpclient.NameValuePair

void addSign(List<NameValuePair> data) {
    String sig = "";
    for (NameValuePair pair : data) {
        sig += pair.getName() + "=" + pair.getValue();
    }
    sig += "62f8ce9f74b12f84c123cc23437a4a32";
    sig = md5(sig); // I assume you have an md5 method somewhere.

    // You need to add the sig to the list
    data.add(new BasicNameValuePair("sig", sig));
}