public interface ThrowingFunction<ParameterType, ReturnType> {
    ReturnType invoke(ParameterType p) throws Exception;
}

public class Mcve {
    public Mcve(String s) throws Exception {
        // whatever
    }
    public static void main(String[] args) {
        ThrowingFunction<String, Mcve> mcveFactory = Mcve::new;
    }
}