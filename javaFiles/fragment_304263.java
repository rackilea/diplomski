public enum EnumProp {
    PROP_1("key", "defaultValue"),
    ...

    EnumProp(String key, String defaultValue){
        this.key = key;
        this.defaultValue = defaultValue;
    }
}