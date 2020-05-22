String work(String S){
    int whitespace; int count=0;    String wrd=new String[5]
    int lenghth=S.length();
    int t=0;
    while(t<length){
        if(S.charAt(t)=='') {   
            whitespace++;
            count++;
        }
        else{
            wrd[count]+=S.charAt(t);
        }
        Random rand = new Random();
        int  n;
        String blank="";
        for(int j=1;j<6;j++){
            n = rand.nextInt(4) + 0;
            blank.append(wrd[n]);
        }
        return blank;
    }
    //HERE
    return ""; // or return a proper default value
}