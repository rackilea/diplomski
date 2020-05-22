public int count(String str){

    int count=0;
    String str1="";
    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        if(ch>=65 && ch <=90){
        ch=(char)(ch + 32);
       str1=str1 + ch;
        }
        else
        str1=str1+ch;
    }
   int index=str1.indexOf("hello");
   System.out.println(index);
   while(index!=-1)
   {
       index=str1.indexOf("hello",index+1);

       count++;

   }
   return count; 

}