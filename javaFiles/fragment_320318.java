interface IA<X extends IA<X>>{}

class A<X extends IA<X>> implements IA<X>{}

class W<X extends IA<X>>{}

class M<X extends IA<X>> extends W<X>{
    X anx;

    public M(X x){} //Type X here is not compatibile with IA in the test code 
}


//Testing code in a different class
public <X extends IA<X>> void check() {

    IA<X> a = new A<X>();
    W<X> s = new M<X>(null); //Doesn't compile because IA<X> is not the same as 'X', even though <X extends IA> 
    W<X> ss = new M(a);    //Compiles, but with suppressed warnings

    X aa = new A<X>();  //this is completely illegal  
    W<X> sss = new M<X>(aa); //compiles
}