public static <T> void reverse(List<T> list) {
    int a =0, b = list.size()-1;
    while ( a < b ) {
        T a_val = list.get(a);
        list.set( a, list.get(b) );
        list.set( b, a_val );
        a++;
        b--;
    }
}