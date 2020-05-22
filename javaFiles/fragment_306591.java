String functionName(int number){
   StringBuilder str = new StringBuilder("{");
   for(int i = 1; i <= number; i++){
      str.append(Integer.toString(i)).append(", ");}
   String string = str.toString().trim();
   string = string.substring(0, str.length()-1);
   string += "}";
   return string;
}