class ProcessingException  {
    private String errorMessage;

    @JsonCreator
    public ProcessingException(@JsonProperty("errorMessage") String errorMessage) {
        if (errorMessage == null) {
            throw new IllegalArgumentException("'errorMessage' can't be null");
        }
        this.errorMessage = errorMessage;
    }
    // getters, setters and other methods
}