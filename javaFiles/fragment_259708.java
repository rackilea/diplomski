import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

final class ExecuteGroovyScriptExample {

    public static void main(String[] args) {
        final String script = "a = 1.0 \n" +
                "def mul2(x) { 2.0 * x }\n";

        final Binding binding = new Binding();

        final GroovyShell gs = new GroovyShell(binding);
        final Script sc = gs.parse(script);
        sc.run();

        System.out.printf("binding.getVariable(\"a\") == %s\n", binding.getVariable("a"));
    }
}