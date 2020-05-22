public static String reformat(String str){
    double d = 0;
    DecimalFormat df=null;
    try {
        d = Double.parseDouble(str);
    } catch (NumberFormatException numberFormatException) {
        return "0.00000";
    }
    if(d>=0){
    String[] sp=str.split("\\.");
    if(sp[0].length()==0)
    df= new DecimalFormat("0.00000");
    if(sp[0].length()==1)
    df= new DecimalFormat("0.00000");
    if(sp[0].length()==2)
        df= new DecimalFormat("00.0000");
    if(sp[0].length()==3)
        df= new DecimalFormat("000.000");
    if(sp[0].length()==4)
        df= new DecimalFormat("0000.00");
    if(sp[0].length()==5)
        df= new DecimalFormat("00000.0");
    }
    else{
    String[] sp=str.split("\\.");
    if(sp[0].length()==1)
    df= new DecimalFormat("0.0000");
    if(sp[0].length()==2)
    df= new DecimalFormat("0.0000");
    if(sp[0].length()==3)
        df= new DecimalFormat("00.000");
    if(sp[0].length()==4)
        df= new DecimalFormat("000.00");
    if(sp[0].length()==5)
        df= new DecimalFormat("0000.0");
    if(sp[0].length()==6)
        df= new DecimalFormat("000000");
    }

    try {
        return df.format(d);
    } catch (Exception e) {
        return "0.00000";
    }
}