public @interface SomeAnnotation{
    int value();
}



void annotate(new SomeAnnotation() {
    int value() {
         return 5;
    }
}