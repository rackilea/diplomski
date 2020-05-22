public class myCustomValidator implements ContraintValidator <MyAnnotation, MyAnnotatedClass> {

    public void initialize (...){ ... };

    public boolean isValid (MyAnnotatedClass myAnnotatedClass) {

        // access to elements of your myAnnotatedClass

    }
}