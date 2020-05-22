public String gettohexastring (String ss) 
{
 String toBuild="";
 String toRet="";
 int endi=ss.length();
 int begi=endi;
 for(int ii=0;ii<ss.length()-4;ii+=4)
 {
      endi=ss.length()-ii;
      begi=endi-4;
     String test=ss.substring(begi, endi);
     toBuild +=Long.toHexString(Long.parseLong(test),2);
 }
 endi=begi;
 begi=0;
 toBuild +=Long.toHexString(Long.parseLong(ss.substring(begi,endi),2));
 //To Reverse hex symbols
 for(int ii=toBuild.length();ii>=1;ii--)
 {
     toRet +=toBuild.substring(ii-1, ii);
 }
 return toRet;
}