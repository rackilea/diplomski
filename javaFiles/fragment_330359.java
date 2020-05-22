public static class Resp {
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Resp{" +
                "error='" + error + '\'' +
                '}';
    }
}