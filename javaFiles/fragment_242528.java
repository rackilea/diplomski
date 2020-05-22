Map<String, String> myData = new HashMap<String, String>();
String key = "check_radio_yes_name[";
for (i=0; i<5; i++)
    myData.put(key + i + "]", "1");  //add your data instead of "1"
upload_doc = Jsoup.connect(url)
                .cookies(loginCookies)
                .data(myData)...