new TheListener<String>(new Model<String>() {
    public String getFieldValue() {
        return field1;
    }
    public void setFieldValue(String v) {
        field1 = v;
    }
});

new TheListener<String>(new Model<String>() {
    public String getFieldValue() {
        return field2;
    }
    public void setFieldValue(String v) {
        field2 = v;
    }
});