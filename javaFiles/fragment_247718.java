public class WarpDrive {
    private Status status; 
    @JsonDeserialize(using = StatusDeserializer.class)
    public void setStatus(final Status status) {
        this.status = status;
    }
    public Status getStatus() {
        return this.status;
    }
}