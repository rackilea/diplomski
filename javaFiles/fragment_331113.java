public enum FieldEnum {

    firstName("first name"), middleName("middle name"), id("student id");

    String value;

    FieldEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    }