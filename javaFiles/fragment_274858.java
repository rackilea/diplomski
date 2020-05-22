public static String captainCrunch(String s){
    int i = 0;
    char hat = ' ';

    int length = s.length();
    while(i < length){
        if(s.charAt(i) >= 'a' && s.charAt(i) <= 'm'){
            hat = (char)(s.charAt(i) + 13);
        }else if(s.charAt(i) > 'm' && s.charAt(i) <= 'z'){
            hat = (char)(s.charAt(i) - 13);
        }else if(s.charAt(i) == ' '){
            hat = ' ';
        }
        s = s + hat;
        i++;
    }
    return s;
}