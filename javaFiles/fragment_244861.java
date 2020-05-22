public static String encode(String s){
    try{
        return java.net.URLEncoder.encode(s, "UTF-8");
    } catch(UnsupportedEncodingException e){
        throw new IllegalStateException(e);
    }
}