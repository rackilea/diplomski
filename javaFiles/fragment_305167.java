public static String fmt(String s){

    String formatted = "";
    if(s.length() > 1){
        formatted = s.substring(0,1);
        s = s.substring(1);
    }

    while(s.length() > 3){
        formatted += "," + s.substring(0,2);
        s = s.substring(2);
    }
    return formatted + "," + s + ".00"; 
}