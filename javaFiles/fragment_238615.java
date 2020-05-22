class MyClass {
    public MyClass(String string) {
        this(ComplicatedTypeConverter.fromString(string));
    }

    public MyClass(ComplicatedType myType) {
        this.myType = myType;
    }
}

class ComplicatedTypeConverter {
    public static ComplicatedType fromString(String string) {
        return something;
    }
}