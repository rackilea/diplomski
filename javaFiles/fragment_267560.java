public class GenericFactory extends AbstractFactory {
    public GenericPostProcessorFactory() {
        factory.put("Test", () -> new Test());
        factory.put("TestWithArgs", () -> new TestWithArgs(2,4));
    }    
}