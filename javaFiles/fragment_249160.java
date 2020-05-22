private static LoginBean altPost(String username, String password, String cookie, String token){
    LoginBean loginBean = new LoginBean();
    HttpsURLConnection urlc = null;
    OutputStreamWriter out = null;
    DataOutputStream dataout = null;
    BufferedReader in = null;
    try {
        URL url = new URL(URL_LOGIN_SUBMIT);
        urlc = (HttpsURLConnection) url.openConnection();
        urlc.setRequestMethod("POST");
        urlc.setDoOutput(true);
        urlc.setDoInput(true);
        urlc.setUseCaches(false);
        urlc.setAllowUserInteraction(false);
        urlc.setRequestProperty(HEADER_USER_AGENT, HEADER_USER_AGENT_VALUE_FF);
        urlc.setRequestProperty("Cookie", cookie);
        urlc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        String output = "org.apache.struts.taglib.html.TOKEN="+ URLEncoder.encode(token, HTTP.UTF_8)
                +"&showLogin=true&upgrade=&username="+ URLEncoder.encode(username, HTTP.UTF_8)
                +"&password="+ URLEncoder.encode(password, HTTP.UTF_8)+"&submit="
                +URLEncoder.encode("Secure+Log+in", HTTP.UTF_8);
        dataout = new DataOutputStream(urlc.getOutputStream());
        // perform POST operation
        dataout.writeBytes(output);
        // get response info
        loginBean.setResponseCode(urlc.getResponseCode());
        // get required headers
        String headerName = null;
        StringBuffer newCookie = new StringBuffer(100);
        String redirectLocation = "";
        for (int i=1; (headerName = urlc.getHeaderField(i)) != null;i++) {
            if (headerName.indexOf(COOKIE_VALUE_SESSION) > -1) {
                if (newCookie.length() > 0) {newCookie.append("; ");}
                newCookie.append(headerName);
            }
            if (headerName.indexOf(COOKIE_VALUE_AUTH) > -1) {
                if (newCookie.length() > 0) {newCookie.append("; ");}
                newCookie.append(headerName);
            }
            if (headerName.indexOf("https://") > -1) {
                redirectLocation = headerName;
            }
        }
        loginBean.setCookie(newCookie.toString());
        loginBean.setRedirectUrl(redirectLocation);

        in = new BufferedReader(new InputStreamReader(urlc.getInputStream()),8096);
        String response;
        // write html to System.out for debug
        while ((response = in.readLine()) != null) {
            System.out.println(response);
        }
        in.close();
    } catch (ProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    return loginBean;
}