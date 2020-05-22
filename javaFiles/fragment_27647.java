public String getStrings(String str){
   String regex = "(\\\"(.*?)\\\")|(\\'(.*?)\\')";

   Pattern pattern = Pattern.compile(regex);
   Matcher matcher = pattern.matcher(str);

   String output = "";
   while (matcher.find()){
       output = output+"|"+matcher.group(0)+"|";
   }

   return output;

}