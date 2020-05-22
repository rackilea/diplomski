public class DataType {
    public void setValue(String value) {
        // ...
    }
}

public class ClassOne {
    private DataType dataType;

    public void setDataTypeValue(String value) {
        dataType.setValue(value);
    }
}

public class ClassTwo {
    private DataType anyOtherFieldName;

    public void setDataTypeValue(String value) {
        anyOtherFieldName.setValue(null);
    }
}