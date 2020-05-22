public class custom{
int value;
String text;

public Boolean equals(custom obj){
  if(this.value==obj.value && this.text.equals(obj.text)){
  return true;
 }else{return false;}
}
}