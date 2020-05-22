boolean isNumber = false;
for(int i = 0; i < line.length; i++){
 try{
  Integer.parseInt(String.valueOf(line.charAt(i)));
 }catch(Exception e){
  isNumber = false;
  break;
 }
}
if(isNumber){
 Integer.parse(line);
}