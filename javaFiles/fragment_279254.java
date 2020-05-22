public class Generics_13 {
    static <T> boolean isIn(T x, T[] y) {
        for(int i = 0;i < y.length;i++) 
           if(x.equals(y[i])) return true;

        return false;
    }

    // main() etc follow here
}