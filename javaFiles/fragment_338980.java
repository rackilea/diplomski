import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public class ParameterVerifier {

    private static final Map<String, Verifier<? extends Annotation>> verifiers
        = new HashMap<>();

    static {
        verifiers.put(Range.class.getSimpleName(), new RangeVerifyer());
    }

    public void validate(Method method, Object value) {
        for (Annotation annotation : method.getAnnotations()) {
            String name = annotation.getClass().getSimpleName();
            @SuppressWarnings("unchecked")
            Verifier<Annotation> verifier =
                (Verifier<Annotation>)verifiers.get(name);
            if (verifier != null) {
                boolean valid = verifier.verify(value, annotation);
            }
        }
    }
}