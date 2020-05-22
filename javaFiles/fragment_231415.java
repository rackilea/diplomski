if(check(edittext.getText.toString())){
//do somethingif true
}else{
//else
}

public boolean check(String text){
for(String s: text){
if(s.equalsIngoreCase(text)){
return true;
  }
}
return false;
}