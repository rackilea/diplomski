URL url = new URL(UrlToParse );
    HttpURLConnection con = (HttpURLConnection)url.openConnection();
    int status = con.getResponseCode();
    if (status == 200){
        parser.parse(UrlToParse);  
        ....
    } else {
        // status is not 200
    }