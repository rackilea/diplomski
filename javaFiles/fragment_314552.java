class B{  
strictfp abstract void m();//Illegal combination of modifiers  
}  
class B{  
strictfp int data=10;//modifier strictfp not allowed here  
}  
class B{  
strictfp B(){}//modifier strictfp not allowed here  
}