import clojure.lang.RT;
public class TestRun {
    public static void main(String[] args) throws Exception {
        RT.loadResourceScript("test.clj");
        // var(namespace, function name).invoke(parameters..)
        RT.var("test", "hello").invoke("Daisy Duck");
    }
}