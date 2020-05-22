@FieldName(fieldName = "example")
public class DataType {

    public void setValue(String value) {
        System.out.println(this.getClass().getAnnotation(FieldName.class));
    }

}

public static void main(String[] args) {
    new DataType().setValue("ignored");
}