enum Outcome {
    PASS("Congratulations"),
    FAIL_BLANK("too many blank stares"),
    FAIL_RED("too many Red Herrings"),
    FAIL_NET("network issues");

    private String msg;
    private Outcome(String message) {
       msg = message;
    }

    public String getMsg() { return msg; }
}