public static final Pattern RTL_CHARACTERS = 
    Pattern.compile("[\u0600-\u06FF\u0750-\u077F\u0590-\u05FF\uFE70-\uFEFF]");
Matcher matcher = RTL_CHARACTERS.matcher("براي تست");
if(matcher.find()){
   return true;  // it's RTL
}