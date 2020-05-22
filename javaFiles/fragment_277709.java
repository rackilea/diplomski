import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DokuGenerator {

    public static void main(String[] args) throws Exception {
        new DokuGenerator(StaticClass.class, StaticClass2.class,
                DynamicClass.class);
    }

    public DokuGenerator(Class<?>... classesToDokument) throws Exception {
        List<Docu> documentAnnotations = getDocumentAnnotations(classesToDokument);
        printDocumentation(documentAnnotations);
    }

    private List<Docu> getDocumentAnnotations(Class<?>... classesToDokument)
            throws Exception {
        List<Docu> result = new ArrayList<Docu>();
        for (Class<?> c : classesToDokument)
            if (c.isAnnotationPresent(Docu.class))
                result.add(c.getAnnotation(Docu.class));
            else if (Arrays.asList(c.getInterfaces()).contains(Docu.class))
                result.add((Docu) c.newInstance());
        return result;
    }

    private void printDocumentation(List<Docu> toDocument) {
        for (Docu m : toDocument)
            System.out.println(m.description());
    }

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Docu {
    String description();
}

@Docu(description = "This is a static class!")
class StaticClass {
}

@Docu(description = "This is another static class!")
class StaticClass2 {
}

class DynamicClass implements Docu {

    public DynamicClass() {
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            // ignore exception to make debugging a little harder
        }
    }

    @Override
    public String description() {
        long millis = System.currentTimeMillis();
        new DynamicClass();
        millis = System.currentTimeMillis() - millis;
        return "This is a dynamic class. I run on "
                + System.getProperty("os.name")
                + ". The construction of an instance of this class run for "
                + millis + " milliseconds.";
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return Docu.class;
    }

}