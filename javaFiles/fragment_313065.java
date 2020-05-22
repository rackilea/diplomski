String httpsURL = "https://openam.example.com:8080/openam/json/users?_action=idFromSession";
URL url = new URL(httpsURL);
HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

//add request headers
con.setRequestMethod("POST");
con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:47.0) Gecko/20100101 Firefox/47.0");
con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
con.setRequestProperty("Content-Type", "application/json");

// Add session token as header
con.setRequestProperty("iplanetdirectorypro", "AQIC5wM2LY4SfczUFNs-TJwFrCVAKgR0NulIAyNaIkQmjis.*AAJTSQACMDEA
     AlNLABQtNTQ3NDE2Njc5ODk4MjYzMzA2MQ..*");

// Send post request
con.setDoOutput(true);
// Read output
BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));