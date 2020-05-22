driver.navigate().to(BaseTest.config("url") + "/es/pronosticos");
String link = driver.getPageSource();
String script = "<script>dataLayer.push({'login':'not logged in','site-language':'es','article-type':'2','section1':'error page','section2':'error page > access denied'});</script>";

if (link.contains(script)) System.out.println("Site contains script");
else System.out.println("Site does NOT contain script");