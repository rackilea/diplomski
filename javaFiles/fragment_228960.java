import java.lang.instrument.Instrumentation;

public class SimpleAgent {

    public static void premain(String agentArgs, Instrumentation inst) {

        ClassTransformer transformer = new ClassTransformer();
        inst.addTransformer(transformer);
    }
}