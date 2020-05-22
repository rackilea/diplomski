@CustomAnnotation
public final class Main {

    public static void main(String[] args) {
        CustomAnnotation ca = Main.class.getAnnotation(CustomAnnotation.class);
        MetaAnnotation   ma = ca.annotationType().getAnnotation(MetaAnnotation.class);

        System.out.println("CustomAnnotation#getClass()       = " + ca.getClass());
        System.out.println("CustomAnnotation#annotationType() = " + ca.annotationType());
        System.out.println("MetaAnnotation#value()            = " + ma.value());
    }

}