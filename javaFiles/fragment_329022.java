public static boolean sameDashes(String a, String b){
    int minlength = Math.min(a.length(), b.length());
    String smallstring="";
    String bigstring="";
    if(a.length()== minlength){
        smallstring = a;
        bigstring = b;
    }
    else {
        smallstring = b;
        bigstring =a;
    }
    int counter = 0;
    int x=0;
    int y=0;
    do{     
        if(smallstring.equals(bigstring)){
            return true;
        }
        else if(smallstring.indexOf('-',counter)!= -1){
            y++;
            if(bigstring.charAt(smallstring.indexOf('-',counter))== '-'){
            }
        }
        if(bigstring.indexOf('-',counter)!=-1){
            x++;
        }
        counter++;
    }while(counter<=bigstring.length());
    if(y==x){
        return true;
    }
    else {
        return false;
    }
}