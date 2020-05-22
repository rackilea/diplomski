String UA = "iphone";

boolean isIOS = 
        Pattern.compile("ip(hone|od|ad)", Pattern.CASE_INSENSITIVE).matcher(UA).matches();
boolean isSafari5 = 
        Pattern.compile("(mac os x).*version\\/\\d(.\\d)+ (mobile\\/\\w{5,} )?safari", Pattern.CASE_INSENSITIVE).matcher(UA).matches();

System.out.println(isIOS);