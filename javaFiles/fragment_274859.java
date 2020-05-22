public static String captainCrunch(String s){
    int i = 0;
    StringBuilder builder = new StringBuilder(s);

    while(i < s.length()){
        if(s.charAt(i) >= 'a' && s.charAt(i) <= 'm'){
            builder.setCharAt(i, (char)(s.charAt(i) + 13));
        }else if(s.charAt(i) > 'm' && s.charAt(i) <= 'z') {
            builder.setCharAt(i, (char) (s.charAt(i) - 13));
        }
        i++;
    }
    return builder.toString();
}