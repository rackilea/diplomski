import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class DokuGenerator {

    public static void main(String[] args) throws Exception {
        new DokuGenerator(StaticClass.class, StaticClass2.class);
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