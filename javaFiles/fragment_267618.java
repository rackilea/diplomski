package a;
class A{
protected int x;
}
class B extends A{
//x can be accessed from this class
} 

class C extends B {
//x can be accessed from this class
}
class D{
//x can be accesed this class but you will have to create A's instance 
}

package B 
class One {
//cannot access x from this class
}
class Two extends A {
//can access x from this class
}