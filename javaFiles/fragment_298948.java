/*** chrs besides these will be removed */
static final String allowedChrs = "$€¥£0123456789,.";
public static String step6(String str){
    int sizeOfString = str.length();
    StringBuilder tmp = new StringBuilder();
    for(int i=0;i<sizeOfString;++i){
        if(allowedChrs.indexOf(str.charAt(i)) > -1){
            tmp.append(str.charAt(i));
        }    
    }
    return tmp.toString();
}