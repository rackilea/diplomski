public class Main {
    public static void main(String[] args) {
        JythonObjectFactory factory = JythonObjectFactory.getInstance();
        ArithType a = (ArithType) factory.createObject(ArithType.class, "Arith");

        String[] paths = {"DIRECTORY1", "DIRECTORY2"};
        JythonObjectFactory.setupPath(paths);                        
        ...