public class VariableContextHolder {

/**
 * ThreadLocal with map storing variables
 */
private final ThreadLocal<Map<String, Object>> threadlocal = new ThreadLocal<>();

private static VariableContextHolder instance;

private VariableContextHolder () {

}

public final static VariableContextHolder getInstance() {
    if (instance == null) {
        instance = new VariableContextHolder ();
    }
    return instance;
}

public Map<String, Object>get() {
    return threadlocal.get();
}

public void set(Map<String, Object>map) {
    threadlocal.set(map);
}

public void clear() {
    threadlocal.remove();
}
}