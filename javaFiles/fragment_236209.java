import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.collections.Lists;
import org.testng.internal.ClassHelper;

public class CompositeTransformer implements IAnnotationTransformer {
  private static final String JVM_ARGS =
      "com.rationaleemotions.github.issue1894.Listener1, com.rationaleemotions.github.issue1894.Listener2";
  private List<IAnnotationTransformer> transformers = Lists.newArrayList();

  public CompositeTransformer() {
    // Ideally this would get a value from the command line. But just for demo purposes
    // I am hard-coding the values.
    String listeners = System.getProperty("transformers", JVM_ARGS);

    Arrays.stream(listeners.split(","))
        .forEach(
            each -> {
              Class<?> clazz = ClassHelper.forName(each.trim());
              IAnnotationTransformer transformer =
                  (IAnnotationTransformer) ClassHelper.newInstance(clazz);
              transformers.add(transformer);
            });
  }

  @Override
  public void transform(
      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    for (IAnnotationTransformer each : transformers) {
      each.transform(annotation, testClass, testConstructor, testMethod);
    }
  }
}