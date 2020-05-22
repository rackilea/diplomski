static class Height{
    @JacksonXmlProperty(localName="height")
    public String value;

    public Height() {}

    public Height(String value) {
        this.value = value;
    }

}