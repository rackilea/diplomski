String getChangedString(String toBeChanged){
   String changedString = toBeChanged;

   while (changedString.indexOf("<tagname>") >= 0)
   {
     changedString = changedString.substring(0, changedString.indexOf("<tagname>")) +
       "whatever replacement string" +
       changedString.substring(changedString.indexOf("</tagname>") + "</tagname>".length());
   }


   return changedString;
}