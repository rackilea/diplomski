// Obtain SID
    GetMethod getLogin = new GetMethod("https://www.google.com/accounts/ClientLogin?service=reader&Email="+
            login+"&Passwd="+password);
    client.executeMethod(getLogin);
    String loginText = getLogin.getResponseBodyAsString();
    // The value of SID is loginText.substring (4,firstLineLength)
    BufferedReader reader = new BufferedReader(new StringReader(loginText));
    String SID = loginText.substring(4, reader.readLine().length() );

GetMethod grabData = new GetMethod("http://www.google.com/reader/atom/user/-/state/com.google/broadcast");
grabData.setRequestHeader("Cookie", "SID="+SID);
client.executeMethod(grabData);