Document doc = Jsoup.connect("http://www.facebook.com")
.data("email", "myemailid")
.data("pass", "mypassword")
// and other hidden fields which are being passed in post request.
.userAgent("Mozilla")
.post();
System.out.println(doc); // will print html source of homepage of facebook.