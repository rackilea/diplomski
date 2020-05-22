class A {
   B myB; 
} 
class B { 
   A myA; 
} 

/* later */  
A a = new A(); 
B b = new B();  
a.b = b; 
b.a = a;