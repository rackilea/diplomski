public class TestBean {

    private String complete;
    public String getComplete() { return complete; }
    public void setComplete(final String complete) { this.complete = complete; }

    private String getterOnly;
    public String getGetterOnly() { return getterOnly; }

    private String setterOnly;
    public void setSetterOnly(final String setterOnly) { this.setterOnly = setterOnly; }

    public String getNoBackingField() { return ""; }

}