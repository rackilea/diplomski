String userAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36";
// get a session for tr and en domain
String tempobetSession = Jsoup.connect("https://www.tempobet.com/").userAgent(userAgent).execute().cookie("GAMBLINGSESS");
String tempobet22Session = Jsoup.connect("https://www.tempobet22.com/").userAgent(userAgent).execute().cookie("GAMBLINGSESS");
// tell tr domain that we wont to go to en without following the redirect
String redirect = Jsoup.connect("https://www.tempobet22.com/?change_lang=https://www.tempobet.com/")
    .userAgent(userAgent).cookie("GAMBLINGSESS", tempobet22Session).followRedirects(false).execute().header("Location");
// Redirect goes to en domain including our hashed tr-cookie as parameter - but this redirect needs a en-cookie
Response response = Jsoup.connect(redirect).userAgent(userAgent).cookie("GAMBLINGSESS", tempobetSession).execute();
// finally...
Document doc = Jsoup.connect("https://www.tempobet.com/league191_5_0.html").userAgent(userAgent).cookies(response.cookies()).get();