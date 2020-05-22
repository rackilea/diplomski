StringBuilder sb = new StringBuilder("yourString");
for(int i=0;i<sb.length();i++){
    if(sb.charAt(i) == '5'){ // want to compare '5' 
      sb.deleteCharAt(i);
    } else {
      sb.setCharAt(i,'6');
    }
}
String newString = sb.toString;