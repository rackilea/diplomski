if(!str.contains("www")){
  if(str.contains("://"))
    str=str.replace("://","://www.");
  else
    str="www."+str;
}