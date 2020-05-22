public class ParameterPassingTest {
    static SomeObject someStaticObject;

    public static void main(String[] args) {
        // initialize a static object reference
        someStaticObject = new SomeObject("I am a static Object", 10);

        System.out.println("My static object before: " + someStaticObject);

        // try modifying the reference by value
        modifySomeObjectByValue(someStaticObject);
        // try printing the value, it will be the same
        System.out.println("My static object after mod-by-value: " + someStaticObject);

        // now, try modifying by object reference
        modifySomeObjectByReference(someStaticObject);

        // print again. new values should be observed
        System.out.println("My static object after mod-by-reference: " + someStaticObject);
    }

    // this method tries to modify the original object by assigning directly to the method parameter. It won't work.
    public static void modifySomeObjectByValue(SomeObject someObject) {
        SomeObject newObject = new SomeObject("I am another object, from a local method", 20);
        someObject = newObject; // try to modify the original object by assigning to the parameter directly
    }

    // this method tries to modify the original object by using the object's public interface. It works.
    public static void modifySomeObjectByReference(SomeObject someObject) {
        // try to modify the original object by using the reference passed in
        someObject.setaString("I have been modified by a method");
        someObject.setAnInt(50);
    }
}

// simple, generic class object with some fields.
class SomeObject {
    String aString;
    int anInt;

    public SomeObject(String aString, int anInt) {
        this.aString = aString;
        this.anInt = anInt;
    }

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public String toString() {
        return "aString = " + getaString() + " | anInt = " + getAnInt();
    }
}