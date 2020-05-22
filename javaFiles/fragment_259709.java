import groovy.lang.GroovyShell;
import groovy.lang.Script;

final class ExecuteGroovyScriptExample {

    public static void main(String[] args) {
        final String script = "a = 1.0 \n" +
                "def mul2(x) { 2.0 * x }\n";

        final GroovyShell gs = new GroovyShell();
        final Script sc = gs.parse(script);
        sc.run();

        System.out.printf("mul2(a) = %s%n", sc.invokeMethod("mul2", gs.evaluate("a")));
    }
}