private class VideoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public VideoNotFoundException(long id) {
        super("Video with id " + id + " not found");
    }

}

@SuppressWarnings("unused")
private class VideoNotFoundExceptionMessage {

    private long timestamp;
    private String error;
    private int status;
    private String exception;
    private String message;

    public VideoNotFoundExceptionMessage() {
        // constructor
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

@ExceptionHandler(VideoNotFoundException.class)
@ResponseBody
@ResponseStatus(value = HttpStatus.NOT_FOUND)
private VideoNotFoundExceptionMessage VideoNotFoundExceptionHandler(VideoNotFoundException e) {
    e.printStackTrace();

    VideoNotFoundExceptionMessage message = new VideoNotFoundExceptionMessage();
    message.setTimestamp(new Date().getTime());
    message.setError("Not Found");
    message.setStatus(404);
    message.setException(e.getClass().getCanonicalName());
    message.setMessage(e.getMessage());
    return message;
}