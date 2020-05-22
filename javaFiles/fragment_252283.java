public static String change(String s){
    if(s.length()>=2&&s.substring(s.length()-2,s.length()-1).equals(s.substring(s.length()-1)))
        s=s.substring(0,s.length()-2);
    if(s.length()<2)
        return s;
    String f="";

    for(int i=0; i<s.length(); i++){
        if((i+1<s.length()-1)&& (s.substring(i,i+1).equals(s.substring(i+1,i+2)))){
            if(s.length()<4){
                f=f+s.substring(s.length()-i)+s.substring(s.length()-1);
                i=i+2;
             }
            else{
              f=f+s.substring(i+2,i+3)+s.substring(i+2,i+3);
              i=i+1;
              }
        }
        else {
            f=f+s.substring(i,i+1);
        }

    }
    if(f.length()<s.length())
        f=f+s.substring(s.length()-1);
    return f;
}