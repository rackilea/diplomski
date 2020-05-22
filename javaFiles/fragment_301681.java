public static <T,Z> T getInt(T a, Z b, PredicateGeneric<T,Z> p){
    if(p.compare(a,b)==true){
        return a;
    }else{
        return b;
    }
}