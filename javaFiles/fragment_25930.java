public String RandomString(String word){

    int no=word.length();
    String temp="";
    String temp2=null;
     while(no>0){
         int genNo=ran.nextInt(word.length());
         if(temp2==null){
             temp2=""+genNo;
             temp=Character.toString(word.charAt(genNo));
             no--;
         }else{
            if(!temp2.contains(""+genNo)){
                temp2=temp2+""+genNo;
                temp=temp+Character.toString(word.charAt(genNo));
                no--;
            }
         }
     }

    if(!temp.equals(word)){
         Log.v("check","temp2 = "+temp2);
         Log.v("check","String = "+temp);
        return temp;
    }else{
        RandomGenerate(word);
    }
    return null;

}