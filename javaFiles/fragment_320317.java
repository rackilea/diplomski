//Testing code in a different class
public <X extends IA<X>> void check() {
    IA<X> a = new A<X>();
    W<subtypeofIA(IA works as well)> s = new M<subtypeofIA(IA works as well)>(a); //Doesn't compile because IA<X> is not the same as 'X', even though <X extends IA> 
    W<X> s = new M(a);    //Compiles, but with suppressed warnings 
}