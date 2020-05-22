CookieManager cookieManager = new CookieManager();
try{
    CookieHandler.setDefault(cookieManager);
}catch(UnsupportedOperationException ex){
    ex.printStackTrace();
}