public class MyBean {

@Cacheable
public String getString(int i) {
    return Integer.toString(i);
}
public void myOtherMethod() {
    String myString = getString(2);
}
}