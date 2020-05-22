class Sample{  

 static void m(String... values){  
  System.out.println("Hello m");  
  for(String s:values){  
   System.out.println(s);  
  }  
 }  

 public static void main(String args[]){  

 m();//zero argument   
 m("hello");//one argument   
 m("I","am","variable-arguments");//three arguments  
 }}