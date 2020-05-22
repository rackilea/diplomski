private InputStream inputStream;
// getter/setter

public String callAction() {
    inputStream = new ByteArrayInputStream(
            "some string".getBytes(StandardCharsets.UTF_8));
    return SUCCESS;
}