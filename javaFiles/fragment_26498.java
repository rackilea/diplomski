import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public final class MyRunner extends BlockJUnit4ClassRunner {

    public MyRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected List<TestRule> getTestRules(Object target) {
        List<TestRule> testRules = super.getTestRules(target);
        testRules.addAll(getStaticFieldTestRules(target));
        return testRules;
    }

    private List<TestRule> getStaticFieldTestRules(Object target) {
        List<TestRule> testRules = new ArrayList<>();
        Class<?> clazz = target.getClass();
        for (Field f : clazz.getFields()) {
            if ((f.getModifiers() & Modifier.STATIC) != 0) {
                if (f.isAnnotationPresent(Rule.class)) {
                    try {
                        testRules.add((TestRule) f.get(target));
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
        }
        return testRules;
    }
}