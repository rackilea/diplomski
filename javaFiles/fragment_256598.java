public String stringSpacer(str = null, int size){
    String before="";
    String after="";
    size-=str.length(); 
    size/=2; 
    if(str.length()%2!=0){after+=" ";}
    for(int i=0;i<size;i++){
        before+=" ";
        after+=" ";
    }
    return before+str+after;
}