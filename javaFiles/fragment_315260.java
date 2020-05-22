public class ClassOne {
    @FieldName(fieldName = "dataType")
    private DataType a;
}

public class ClassTwo {
    @FieldName(fieldName = "dataType")
    private DataType b;
}

public class ClassThree {
    public void doSomething() {
        DataType c = new DataType();
    }
}

public class ClassFour {
    public void doSomething(DataType d) {
        // ...
    }
}