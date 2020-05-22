By captcha = By.xpath("//iframe[@title='recaptcha challenge']");
String src = driver.findElement(captcha).getAttribute("src");
String key = getKey(src);

public String getKey(String src){
    String x = src;
    String y = x.substring(x.indexOf("&k=")+3);
    String key = y.substring(0, StringUtils.ordinalIndexOf(y,"&",1));
    return key;
}