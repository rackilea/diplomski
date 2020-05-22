public static String base(int y,int x){
    int remainder = 0;
    String value = "";
    while(y!=0){
        remainder=y%x; 
        value= remainder + value; 
        y=y/x;

    }

    return value;
}