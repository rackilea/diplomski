// I'm not sure about the right type arguments here
public interface MyEnumInterface<E extends MyEnumInterface & Enum<E>> {
    public static boolean aUsefulNonStaticMethod();
    String getValue();
    MyEnumInfo<E> enumInfo();
}

/** contains some helper methods */
public class MyEnumInfo<E extends MyEnumInterface<E>> {
    private static <E extends MyEnumInterface<E>> MyEnumInfo(Class<E> enumClass) {...}
    // static factory method
    public static <E extends MyEnumInterface<E>> MyEnumInfo<E> infoForClass(Class<E> enumClass) {
        ... return a cached value
    }
    public static <E extends MyEnumInterface<E>> MyEnumInfo(E e) {
         return infoForClass(e.getClass());
    }
    // some helper methods replacing static methods of the enum class     
    E enumForValue(String value) {....}
}

public enum MyEnum implements MyEnumInterface<MyEnum> {
    VALUE_ONE("my data");
    VALUE_TWO("some other data");

    private String myValue; //set via private constructor
    //private constructor not shown

    public boolean aUsefulNonStaticMethod(){
        //do something useful
    }

    public String getValue(){
        return myValue;
    }

    // the ONLY static method in each class
    public static MyEnumInfo<E> staticEnumInfo() {
        return MyEnumInfo.infoForClass(MyEnumClass.class);
    }
    // the non-static version of the above (may be useful or not)
    public MyEnumInfo<E> enumInfo() {
        return MyEnumInfo.infoForClass(getClass());
    }
}