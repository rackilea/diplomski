@Retention(RetentionPolicy.RUNTIME)
@interface ID {
    int value();
}
...
@ID(1337)
void exampleMethod() { ... }
...
newIdentifier = method.getAnnotation(ID.class).value(); //returns 1337 for exampleMethod