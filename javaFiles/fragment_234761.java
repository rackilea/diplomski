public class ResponseImpl implements Response {
    private HttpServletResponse response;

    public ResponseImpl(HttpServletResponse response, Status status) {
        this.response = response;
        this.response.setStatus(status.getCode());
    }

    public OutputStream getOutputStream() {
        return response.getOutputStream();
    }

    // ...
}