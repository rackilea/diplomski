String not(String s){
  return "[^" + s + "]";
}
String pipe = "\\|";

result1 = myString.split(not(pipe) + pipe + not(pipe)); 
result2 = result1.split(pipe + "{2,}");