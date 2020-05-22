CookieStore cookieJar =  Main.cookieManager.getCookieStore();
List<HttpCookie> cookies =  cookieJar.getCookies();

for (HttpCookie ck: cookies) {
if(ck.getName().equals("JSESSIONID")){
          System.out.println("JSESSIONID");
   }else{
          ck.setMaxAge(0);
          System.out.println("CookieHandler retrieved cookie: " + ck);
   }
}