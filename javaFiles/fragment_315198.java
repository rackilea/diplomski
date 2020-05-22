public class ReadCollection { // no generic class!
public static <R extends Reader, C extends Collection<R>> // generic static function! 
        C readColl(File file, Class<? extends C> collClass, Class<? extends R> readClass) {
    C ts = collClass.newInstance()
        Reader t = readClass.newInstance()
        ...
        ts.add(readClass.cast(t.read(strLine)));
        ...
        return ts; 
} }