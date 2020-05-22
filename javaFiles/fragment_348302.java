public class InfoMessage {

    private byte[] body;

    @Lob
    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}