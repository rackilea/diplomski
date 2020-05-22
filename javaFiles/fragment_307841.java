string outStr="";
static String newline = System.getProperty("line.separator");
for (int i=1; i<cardArray.size(); i++){
    outStr+=newline+cardArray[i].toString();
}
return outStr;