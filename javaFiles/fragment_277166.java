public static String repeat(int count, String with) {
    if(count<0){
        return "";
    }
    if(count>1e5){
        return "";
    }
    return new String(new char[count]).replace("\0", with);
}

public static String getFormattedDouble(double num,int posInt,int posFrac){
    if(num == 0) return "0"; // correct 0 value to be print only with one 0
    String sInt = repeat(posInt,"0");
    String sFrac = repeat(posFrac,"0");
    String sSing = num<0 ? "" : "+";
    DecimalFormat form = new DecimalFormat(sSing+sInt+"."+sFrac+"E0");
    String s = form.format(num);
    s = s.replace("E","e"); // I really thing capital E looks ugly
    return s;
}

public static String[] get2doublesSameExp(double a, double b){
    String[] s = new String[2];
    int expA;
    if(a == 0) expA = 0;
    else       expA = (int)Math.floor(Math.log10(Math.abs(a)));
    int expB;
    if(b == 0) expB = 0;
    else       expB = (int)Math.floor(Math.log10(Math.abs(b)));
    double expDif = Math.abs((double)expA-(double)expB);
    int fractPos = 3;
    if(expDif > 4) fractPos = 1; // too big exponent difference reduce fraction digits
    if(expDif > 6){
        // too big exponent difference print it normally it will be nicer
        s[0] = String.format("%1.3e",a);
        s[1] = String.format("%1.3e",b);
        return s;
    }
    int minExp = Math.min(expA,expB) - 1;
    s[0] = getFormattedDouble(a, expA - minExp, fractPos );
    s[1] = getFormattedDouble(b, expB - minExp, fractPos );
    // just text right justification
    String rightJust = repeat((int)expDif," ");
    int justIdx = expA < expB ? 0 : 1;
    s[justIdx] = rightJust + s[justIdx];
    return s;
}
String[] s = get2doublesSameExp(1.234e-6,11.234e-6);