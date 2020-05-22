public abstract class DatabaseField {
    private String fieldName;

    private DatabaseField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}