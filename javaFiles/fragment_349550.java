interface ConvertibleTo<T> {
    T convert();
}
class ReprChange<T extends ConvertibleTo<S>,
                 S extends ConvertibleTo<T>> { 
    T t; 
    void set(S s) { t = s.convert();    } 
    S get()       { return t.convert(); } 
}