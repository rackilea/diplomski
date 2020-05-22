private static class TopLevel {

    @SerializedName("response")
    private final List<ResponseElement> elements;

    private TopLevel() {
        this.elements = null;
    }
}

private static class ResponseInteger implements ResponseElement {

    private final int value;

    public ResponseInteger(int value) {
        this.value = value;
    }
}

private static class ResponseObject implements ResponseElement {

    @SerializedName("id")
    private final String id;

    @SerializedName("text")
    private final String text;

    private ResponseObject() {
        this.id = null;
        this.text = null;
    }
}

private interface ResponseElement {
    // marker interface
}